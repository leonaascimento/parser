package com.ef;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.ef.presentation.App;
import com.ef.presentation.AppArguments;

public class Parser {
	public static void main(String[] args) throws ClassNotFoundException {
		AppArguments appArguments = new AppArguments();
		JCommander jCommander = JCommander.newBuilder().addObject(appArguments).build();

		jCommander.setProgramName("com.ef.Parser");

		try {
			jCommander.parse(args);
		} catch (ParameterException e) {
			System.out.println(e.getMessage());
			e.usage();
			System.exit(1);
		}

		App app = new AppBuilder().build();

		app.run(appArguments.getThreshold(), appArguments.getDuration(), appArguments.getStartDate(),
				appArguments.getAccessLog());
	}
}
