package com.recruitathon.suitup.exception;

public class ApplicationAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 2L;

	public ApplicationAlreadyExistsException(String string){
		super(string);
	}
}
