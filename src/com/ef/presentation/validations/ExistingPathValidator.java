package com.ef.presentation.validations;

import java.io.File;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class ExistingPathValidator implements IParameterValidator {
	@Override
	public void validate(String name, String value) throws ParameterException {
		boolean exists = new File(value).exists();
		if (!exists)
			throw new ParameterException("Argument " + name + " should be an existing path");
	}
}
