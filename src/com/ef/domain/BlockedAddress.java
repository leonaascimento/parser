package com.ef.domain;

public class BlockedAddress {
	private int id;
	private String ip;
	private String reason;

	public BlockedAddress() {
	}

	public BlockedAddress(String ip, String reason) {
		setIp(ip);
		setReason(reason);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
