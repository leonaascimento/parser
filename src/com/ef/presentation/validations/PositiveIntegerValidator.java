package com.ef.presentation.validations;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class PositiveIntegerValidator implements IParameterValidator {
	@Override
	public void validate(String name, String value) throws ParameterException {
		int n = Integer.parseInt(value);
		if (n <= 0)
			throw new ParameterException("Argument " + name + " should be a positive integer");
	}
}
