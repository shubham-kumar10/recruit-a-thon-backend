package com.recruitathon.suitup.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitathon.suitup.exception.UserAlreadyExistsException;
import com.recruitathon.suitup.model.User;
import com.recruitathon.suitup.service.AppUserDetailsService;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@PostMapping("/signUp")
	public void signupUser(@RequestBody @Valid User newUser) throws UserAlreadyExistsException {
		LOGGER.info("Start of signupUser");
		LOGGER.debug("new User is {}", newUser);
		appUserDetailsService.signup(newUser);
		LOGGER.info("End of signupUser");
	}
	
//	@PostMapping("/business")
//	public void signUpBusiness(@RequestBody @Valid MentorDTO mentorDetails) {
//		appUserDetailsService.addMentor(mentorDetails);
//	}
	
}
