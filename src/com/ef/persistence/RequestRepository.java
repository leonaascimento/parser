package com.ef.persistence;

import java.util.Collection;
import java.util.Date;

import javax.sql.DataSource;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import com.ef.application.models.RemoteAddressModel;

public class RequestRepository {
	private Sql2o db;

	public RequestRepository(DataSource dataSource) {
		this.db = new Sql2o(dataSource);
	}

	public Collection<RemoteAddressModel> getRemoteAddressesWithTooManyRequests(int threshold, Date startDate,
			Date endDate) {
		final String sql = "select remote_address ip from access_log.request "
				+ "where date >= :startDate and date < :endDate group by remote_address "
				+ "having count(*) >= :threshold";

		try (Connection connection = db.open()) {
			return connection.createQuery(sql).addParameter("startDate", startDate).addParameter("endDate", endDate)
					.addParameter("threshold", threshold).executeAndFetch(RemoteAddressModel.class);
		}
	}

	public void loadFile(String filePath) {
		final String sql = "load data local infile :file_path into table access_log.request "
				+ "fields terminated by '|' enclosed by '\"' lines terminated by '\r\n' "
				+ "(date, remote_address, method, response_status, user_agent)";

		try (Connection connection = db.open()) {
			connection.createQuery(sql).addParameter("file_path", filePath).executeUpdate();
		}
	}
}
