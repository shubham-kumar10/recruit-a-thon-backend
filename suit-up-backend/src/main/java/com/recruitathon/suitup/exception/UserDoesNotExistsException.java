package com.recruitathon.suitup.exception;

public class UserDoesNotExistsException extends Exception {

	private static final long serialVersionUID = 2L;

	public UserDoesNotExistsException(String string){
		super(string);
	}
}
