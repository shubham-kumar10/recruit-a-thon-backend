package com.recruitathon.suitup.exception;

public class CandidateAlreadyExistException extends Exception {

	private static final long serialVersionUID = 5L;

	public CandidateAlreadyExistException(String string){
		super(string);
	}
}
