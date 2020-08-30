package com.recruitathon.suitup.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

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
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Start OF authenticate()");
		LOGGER.info(authHeader);
		System.out.println(authHeader);
		Map<String, String> authmap = new HashMap<String, String>();
		/*Extract Username from header*/
		String username = getUser(authHeader);
		authmap.put("username", username);
		User user = UserRepository.findByUserName(username);
		//String role = user.getRole().equals("C") ? "Candidate" : user.getRole().equals("Recruiter") ? "Mentor":"";
		
		/* Adding user details to auth-map */
		authmap.put("id", user.getId().toString());
		authmap.put("firstname", user.getFirstName());
		authmap.put("lastname", user.getLastName());
		authmap.put("token", generateJwt(getUser(authHeader)));
		//authmap.put("role", role);
		
		LOGGER.info("End of authenticate()");
		
		return authmap;
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
