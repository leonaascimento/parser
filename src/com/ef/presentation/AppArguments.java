package com.ef.presentation;

import java.util.Date;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.ef.common.Duration;
import com.ef.presentation.validations.DurationValidator;
import com.ef.presentation.validations.ExistingPathValidator;
import com.ef.presentation.validations.PositiveIntegerValidator;

@Parameters(separators = "=")
public class AppArguments {
	@Parameter(names = "--threshold", description = "The request limit of a remote address", required = true, validateWith = PositiveIntegerValidator.class, order = 3)
	private Integer threshold;

	@Parameter(names = "--duration", description = "The time span to be considered", required = true, validateWith = DurationValidator.class, order = 2)
	private String duration;

	@Parameter(names = "--startDate", description = "The start date of the analysis", required = true, order = 1)
	private Date startDate;

	@Parameter(names = "--accesslog", description = "The access log file path", required = false, validateWith = ExistingPathValidator.class, order = 0)
	private String accesslog;

	public int getThreshold() {
		return threshold;
	}

	public Duration getDuration() {
		return Duration.fromName(duration);
	}

	public Date getStartDate() {
		return startDate;
	}

	public String getAccessLog() {
		return accesslog;
	}
}
