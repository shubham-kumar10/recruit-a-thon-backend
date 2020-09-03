package com.recruitathon.suitup.controller;

import java.util.HashMap;
import java.util.Map;

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
	public Map<String, String> signupUser(@RequestBody @Valid User newUser) throws UserAlreadyExistsException {
		LOGGER.info("Start of signupUser");
		LOGGER.debug("new User is {}", newUser);
		User user = appUserDetailsService.signup(newUser);
		Map<String, String> authmap = new HashMap<String, String>();
		String username = user.getUserName();
		authmap.put("username", username);
		authmap.put("id", user.getId().toString());
		authmap.put("firstname", user.getFirstName());
		authmap.put("lastname", user.getLastName());
		authmap.put("token", null);
		return authmap;
	}
	
}

