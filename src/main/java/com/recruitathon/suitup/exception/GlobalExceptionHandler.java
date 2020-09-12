package com.recruitathon.suitup.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = UserAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleGenericNotFoundException(UserAlreadyExistsException e) {
		ErrorResponse error = new ErrorResponse("USER_ALREADY_EXISTS_ERROR", e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleGenericNotFoundException(InvalidCredentialsException e) {
		ErrorResponse error = new ErrorResponse("UNAUTHORIZED_ERROR", e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.UNAUTHORIZED.value()));
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value = CandidateAlreadyExistException.class)
	public ResponseEntity<ErrorResponse> handleGenericNotFoundException(CandidateAlreadyExistException e) {
		ErrorResponse error = new ErrorResponse("CANDIDATE_ALREADY_EXISTS", e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = CandidateDoesNotExistException.class)
	public ResponseEntity<ErrorResponse> handleGenericNotFoundException(CandidateDoesNotExistException e) {
		ErrorResponse error = new ErrorResponse("CANDIDATE_DOES_NOT_EXIST", e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = JobDoesNotExistException.class)
	public ResponseEntity<ErrorResponse> handleGenericNotFoundException(JobDoesNotExistException e) {
		ErrorResponse error = new ErrorResponse("INTERNAL_SERVER_ERROR", e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = UserDoesNotExistsException.class)
	public ResponseEntity<ErrorResponse> handleGenericNotFoundException(UserDoesNotExistsException e) {
		ErrorResponse error = new ErrorResponse("INTERNAL_SERVER_ERROR", e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
