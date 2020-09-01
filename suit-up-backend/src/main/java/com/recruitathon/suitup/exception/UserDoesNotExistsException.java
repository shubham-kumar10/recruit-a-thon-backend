package com.recruitathon.suitup.exception;

public class UserDoesNotExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserDoesNotExistsException(String string){
		super(string);
	}
}
