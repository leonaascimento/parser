package com.ef.application;

import java.util.Collection;
import java.util.Date;

import com.ef.application.models.RemoteAddressModel;
import com.ef.persistence.RequestRepository;

public class GetRemoteAddressesWithTooManyRequestsQuery {
	private RequestRepository repository;

	public GetRemoteAddressesWithTooManyRequestsQuery(RequestRepository repository) {
		this.repository = repository;
	}

	public Collection<RemoteAddressModel> execute(int threshold, Date startDate, Date endDate) {
		return repository.getRemoteAddressesWithTooManyRequests(threshold, startDate, endDate);
	}
}
