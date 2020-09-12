package com.recruitathon.suitup.exception;

public class CandidateDoesNotExistException extends Exception {

	private static final long serialVersionUID = 5L;

	public CandidateDoesNotExistException(String string){
		super(string);
	}
}
