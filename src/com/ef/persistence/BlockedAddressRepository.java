package com.ef.persistence;

import java.util.Collection;

import javax.sql.DataSource;

import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import com.ef.domain.BlockedAddress;

public class BlockedAddressRepository {
	private Sql2o db;

	public BlockedAddressRepository(DataSource dataSource) {
		this.db = new Sql2o(dataSource);
	}

	public void addRange(Collection<BlockedAddress> blockedAddresses) {
		final String sql = "insert into access_log.blocked_address(ip, reason) values (:ip, :reason)";

		try (Connection connection = db.beginTransaction()) {
			Query query = connection.createQuery(sql);

			for (BlockedAddress blockedAddress : blockedAddresses) {
				query.addParameter("ip", blockedAddress.getIp()).addParameter("reason", blockedAddress.getReason())
						.addToBatch();
			}

			query.executeBatch();
			connection.commit();
		}
	}
}
