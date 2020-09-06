package com.recruitathon.suitup.exception;

public class JobDoesNotExistException extends Exception {

	private static final long serialVersionUID = 6L;

	public JobDoesNotExistException(String string){
		super(string);
	}
}
