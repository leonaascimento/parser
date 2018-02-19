package com.ef.domain;

import java.util.Date;

public class Request {
	private int id;
	private Date date;
	private String remoteAddress;
	private String method;
	private int responseStatus;
	private String userAgent;

	public Request() {
	}

	public Request(Date date, String remoteAddress, String method, int responseStatus, String userAgent) {
		setDate(date);
		setRemoteAddress(remoteAddress);
		setMethod(method);
		setResponseStatus(responseStatus);
		setUserAgent(userAgent);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
}
