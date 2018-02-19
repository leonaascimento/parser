package com.ef.presentation.validations;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class DurationValidator implements IParameterValidator {
	@Override
	public void validate(String name, String value) throws ParameterException {
		switch (value) {
		case "hourly":
			break;
		case "daily":
			break;
		default:
			throw new ParameterException("Argument " + name + " should be a valid duration (hourly or daily)");
		}
	}
}
