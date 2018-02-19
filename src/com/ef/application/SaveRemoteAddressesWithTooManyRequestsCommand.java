package com.ef.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.ef.application.models.RemoteAddressModel;
import com.ef.common.DateService;
import com.ef.domain.BlockedAddress;
import com.ef.persistence.BlockedAddressRepository;

public class SaveRemoteAddressesWithTooManyRequestsCommand {
	private BlockedAddressRepository repository;
	private DateService dateService;

	public SaveRemoteAddressesWithTooManyRequestsCommand(BlockedAddressRepository repository, DateService dateService) {
		this.repository = repository;
		this.dateService = dateService;
	}

	public void execute(Collection<RemoteAddressModel> remoteAddresses, int threshold, Date startDate, Date endDate) {
		Collection<BlockedAddress> blockedAddresses = new ArrayList<>();

		for (RemoteAddressModel remoteAddress : remoteAddresses) {
			String ip = remoteAddress.getIp();
			String reason = String.format("%s has %d or more requests between %s and %s", ip, threshold,
					dateService.formatStartDate(startDate), dateService.formatEndDate(endDate));

			blockedAddresses.add(new BlockedAddress(ip, reason));
		}

		repository.addRange(blockedAddresses);
	}
}
