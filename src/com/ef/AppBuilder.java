package com.ef;

import java.util.ResourceBundle;

import com.ef.application.GetRemoteAddressesWithTooManyRequestsQuery;
import com.ef.application.LoadAccessLogFileCommand;
import com.ef.application.SaveRemoteAddressesWithTooManyRequestsCommand;
import com.ef.common.DateService;
import com.ef.persistence.BlockedAddressRepository;
import com.ef.persistence.RequestRepository;
import com.ef.presentation.App;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

class AppBuilder {
	private DateService dateService;
	private RequestRepository requestRepository;
	private BlockedAddressRepository blockedAddressRepository;
	private LoadAccessLogFileCommand loadAccessLogFile;
	private GetRemoteAddressesWithTooManyRequestsQuery getRemoteAddressesWithTooManyRequests;
	private SaveRemoteAddressesWithTooManyRequestsCommand saveRemoteAddressesWithTooManyRequests;

	AppBuilder() throws ClassNotFoundException {
		// load properties
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String url = bundle.getString("db.url");
		String user = bundle.getString("db.user");
		String password = bundle.getString("db.password");

		// setup drivers
		Class.forName("com.mysql.jdbc.Driver");

		// setup data source
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);

		// setup persistence
		this.requestRepository = new RequestRepository(dataSource);
		this.blockedAddressRepository = new BlockedAddressRepository(dataSource);

		// setup common
		this.dateService = new DateService();

		// setup application
		this.loadAccessLogFile = new LoadAccessLogFileCommand(requestRepository);
		this.getRemoteAddressesWithTooManyRequests = new GetRemoteAddressesWithTooManyRequestsQuery(requestRepository);
		this.saveRemoteAddressesWithTooManyRequests = new SaveRemoteAddressesWithTooManyRequestsCommand(
				blockedAddressRepository, dateService);
	}

	App build() {
		return new App(loadAccessLogFile, getRemoteAddressesWithTooManyRequests, saveRemoteAddressesWithTooManyRequests,
				dateService);
	}
}
