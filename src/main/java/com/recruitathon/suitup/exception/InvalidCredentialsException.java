package com.recruitathon.suitup.exception;

public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = 3L;

	public InvalidCredentialsException(String string){
		super(string);
	}
}
