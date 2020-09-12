package com.recruitathon.suitup.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitathon.suitup.dto.UserDetails;
import com.recruitathon.suitup.exception.UserAlreadyExistsException;
import com.recruitathon.suitup.model.User;
import com.recruitathon.suitup.service.AppUserDetailsService;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@PostMapping("/signUp")
	public UserDetails signupUser(@RequestBody @Valid User newUser) throws UserAlreadyExistsException {
		LOGGER.info("Start of signupUser");
		LOGGER.debug("new User is {}", newUser);
		User user = appUserDetailsService.signup(newUser);
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user.getUserName());
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		return new UserDetails(user.getId(), user.getFirstName(), user.getLastName(), user.getUserName(), token,
				user.getRole(), user.getContactNumber(), user.getConfirmedSignUp());
	}

	@PutMapping("/user")
	public boolean updateUser(@RequestBody UserDetails user) {
		return appUserDetailsService.updateUser(user);
	}
}
