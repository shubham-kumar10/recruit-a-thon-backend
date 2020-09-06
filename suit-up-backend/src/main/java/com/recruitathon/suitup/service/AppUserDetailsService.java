package com.recruitathon.suitup.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.recruitathon.suitup.exception.UserAlreadyExistsException;
import com.recruitathon.suitup.model.AppUser;
import com.recruitathon.suitup.model.User;
import com.recruitathon.suitup.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found!");
		} else {
			LOGGER.info("user is:" + user);
			AppUser appUser = new AppUser(user);
			LOGGER.info("userDetails is: " + appUser);
			return appUser;
		}

	}

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User signup(User newUser) throws UserAlreadyExistsException {
		LOGGER.info("NEW User IS: " + newUser);
		System.out.println(newUser);
		User user = userRepository.findByUserName(newUser.getUserName());
		if (user != null) {
			throw new UserAlreadyExistsException("User Already Exists With This Email.");
		} else {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = bCryptPasswordEncoder.encode(newUser.getPassword());
			newUser.setPassword(encodedPassword);
			userRepository.save(newUser);
		}
		return (userRepository.findByUserName(newUser.getUserName()));
	}
	
	@org.springframework.transaction.annotation.Transactional()
	public boolean updateUser(com.recruitathon.suitup.dto.UserDetails newUser){
		Optional<User> entity= userRepository.findById(newUser.getId());
		if(entity.isPresent()) {
			User user = entity.get();
			user.setContactNumber(newUser.getContactnumber());
			user.setRole(newUser.getRole());
			user.setUserName(newUser.getUsername());
			userRepository.save(user);
			return true;
		}
		else
			return false;
	}
}
