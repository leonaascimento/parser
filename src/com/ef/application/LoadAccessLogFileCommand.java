package com.ef.application;

import com.ef.persistence.RequestRepository;

public class LoadAccessLogFileCommand {
	private RequestRepository repository;

	public LoadAccessLogFileCommand(RequestRepository repository) {
		this.repository = repository;
	}

	public void execute(String filePath) {
		repository.loadFile(filePath);
	}
}
