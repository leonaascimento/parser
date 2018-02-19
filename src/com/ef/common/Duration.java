package com.ef.common;

public enum Duration {
	HOURLY("hourly", 1), DAILY("daily", 24);

	private final String name;
	private final int hours;

	private Duration(String name, int hours) {
		this.name = name;
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public int getHours() {
		return hours;
	}

	public static Duration fromName(String name) {
		if (name != null)
			for (Duration duration : Duration.values())
				if (name.equalsIgnoreCase(duration.name))
					return duration;

		return null;
	}
}
