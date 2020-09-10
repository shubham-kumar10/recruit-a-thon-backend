package com.recruitathon.suitup.controller;

import java.util.Base64;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.recruitathon.suitup.dto.UserDetails;
import com.recruitathon.suitup.model.User;
import com.recruitathon.suitup.repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	UserRepository UserRepository;

	@GetMapping("/authenticate")
	public UserDetails authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Start OF authenticate()");
		LOGGER.info(authHeader);
		/* Extract Username from header */
		String username = getUser(authHeader);
		User user = UserRepository.findByUserName(username);
		String token = generateJwt(getUser(authHeader));
		LOGGER.info("End of authenticate()");

		return new UserDetails(user.getId(), user.getFirstName(), user.getLastName(), user.getUserName(), token,
				user.getRole(), user.getContactNumber(), user.getConfirmedSignUp());
	}

	private String getUser(String authHeader) {
		String user = new String(Base64.getDecoder().decode(authHeader.substring(6)));
		user = user.substring(0, user.indexOf(":"));
		LOGGER.info(user);
		return user;
	}

	private String generateJwt(String user) {

		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		// Set the token issue time as current time
		builder.setIssuedAt(new Date());

		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();
		LOGGER.info(token);
		return token;
	}
}
