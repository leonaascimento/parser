package com.ef.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateService {
	private Calendar calendar;
	private SimpleDateFormat simpleDateFormat;

	public DateService() {
		this.calendar = Calendar.getInstance();
		this.simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
	}

	public Date getNextDate(Date startDate, Duration duration) {
		calendar.setTime(startDate);
		calendar.add(Calendar.HOUR, duration.getHours());
		return calendar.getTime();
	}

	public String formatStartDate(Date startDate) {
		return simpleDateFormat.format(startDate);
	}

	public String formatEndDate(Date endDate) {
		calendar.setTime(endDate);
		calendar.add(Calendar.SECOND, -1);
		return simpleDateFormat.format(calendar.getTime());
	}
}
