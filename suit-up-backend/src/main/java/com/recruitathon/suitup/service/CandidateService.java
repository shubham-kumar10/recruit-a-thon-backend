package com.recruitathon.suitup.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public Candidate getCandidateDetails(String username) {
		User user = userRepository.findByUserName(username);
		return candidateRepository.findByUser(user);
	}

	@Transactional
	public Candidate addDetails(Candidate candidate) {
		User user = userRepository.findById(candidate.getUser().getId());
		candidateRepository.save(candidate);
		return candidateRepository.findByUser(user);
	}
	
	@Transactional
	public byte[] addResume(Candidate candidate) {
		candidateRepository.save(candidate);
		return candidateRepository.findByUser(candidate.getUser()).getResume();
	}

}
