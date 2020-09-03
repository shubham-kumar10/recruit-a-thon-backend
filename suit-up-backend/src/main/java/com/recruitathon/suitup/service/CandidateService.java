package com.recruitathon.suitup.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recruitathon.suitup.dto.ApplicationDetails;
import com.recruitathon.suitup.dto.CandidateDetails;
import com.recruitathon.suitup.exception.UserDoesNotExistsException;
import com.recruitathon.suitup.model.Candidate;
import com.recruitathon.suitup.model.User;
import com.recruitathon.suitup.repository.CandidateRepository;
import com.recruitathon.suitup.repository.UserRepository;

@Service
public class CandidateService {

	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	UserRepository userRepository;

	public CandidateDetails getCandidateDetails(String username) {
		User user = userRepository.findByUserName(username);
		Candidate candidate = candidateRepository.findByUser(user);
		CandidateDetails candidateDetails = new CandidateDetails(candidate.getId(), candidate.getDateOfBirth(),
				candidate.getGender(), candidate.getBio(), candidate.getCountry(), candidate.getCity(),
				candidate.getProfilePicture(), candidate.getResume());
		return candidateDetails;
	}

	@Transactional
	public Candidate addDetails(Candidate candidate, long id) throws UserDoesNotExistsException {
		User user = userRepository.findById(id);
		if (user != null) {
			candidate.setUser(user);
			candidateRepository.save(candidate);
			return candidateRepository.findByUser(user);
		} else
			throw new UserDoesNotExistsException("The given id is not mapped to a User");
	}

	@Transactional
	public byte[] addResume(Candidate candidate) {
		candidateRepository.save(candidate);
		return candidateRepository.findByUser(candidate.getUser()).getResume();
	}

}
