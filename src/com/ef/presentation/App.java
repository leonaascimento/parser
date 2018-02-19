package com.ef.presentation;

import java.util.Collection;
import java.util.Date;

import com.ef.application.GetRemoteAddressesWithTooManyRequestsQuery;
import com.ef.application.LoadAccessLogFileCommand;
import com.ef.application.SaveRemoteAddressesWithTooManyRequestsCommand;
import com.ef.application.models.RemoteAddressModel;
import com.ef.common.DateService;
import com.ef.common.Duration;

public class App {
	private LoadAccessLogFileCommand loadAccessLogFile;
	private GetRemoteAddressesWithTooManyRequestsQuery getRemoteAddressesWithTooManyRequests;
	private SaveRemoteAddressesWithTooManyRequestsCommand saveRemoteAddressesWithTooManyRequests;
	private DateService dateService;

	public App(LoadAccessLogFileCommand loadAccessLogFile,
			GetRemoteAddressesWithTooManyRequestsQuery getRemoteAddresesWithTooManyRequests,
			SaveRemoteAddressesWithTooManyRequestsCommand saveRemoteAddressesWithTooManyRequests,
			DateService dateService) {
		this.loadAccessLogFile = loadAccessLogFile;
		this.getRemoteAddressesWithTooManyRequests = getRemoteAddresesWithTooManyRequests;
		this.saveRemoteAddressesWithTooManyRequests = saveRemoteAddressesWithTooManyRequests;
		this.dateService = dateService;
	}

	public void run(int threshold, Duration duration, Date startDate, String accesslog) {
		if (accesslog != null)
			loadAccessLogFile.execute(accesslog);
		run(threshold, duration, startDate);
	}

	public void run(int threshold, Duration duration, Date startDate) {
		Date endDate = dateService.getNextDate(startDate, duration);

		Collection<RemoteAddressModel> remoteAddresses = getRemoteAddressesWithTooManyRequests.execute(threshold,
				startDate, endDate);

		saveRemoteAddressesWithTooManyRequests.execute(remoteAddresses, threshold, startDate, endDate);

		for (RemoteAddressModel remoteAddress : remoteAddresses)
			System.out.println(remoteAddress.getIp());
	}
}
