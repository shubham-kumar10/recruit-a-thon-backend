package com.recruitathon.suitup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Autowired
	CandidateDetailsService candidateDetails;

	public CandidateDetails getCandidateDetails(long id) {
		User user = userRepository.findById(id);
		Candidate candidate = candidateRepository.findByUser(user);
		CandidateDetails candidateDetails = new CandidateDetails(candidate.getId(), candidate.getDateOfBirth(),
				candidate.getGender(), candidate.getBio(), candidate.getCountry(), candidate.getCity(),
				candidate.getProfilePicture(), candidate.getResume(), candidate.getEducation(),
				candidate.getProject(), candidate.getExperience(), candidate.getSkills());
		return candidateDetails;
	}

	@Transactional
	public CandidateDetails addDetails(Candidate candidate, long id) throws UserDoesNotExistsException {
		User user = userRepository.findById(id);
		if (user != null) {
			candidate.setUser(user);
			candidateRepository.save(candidate);
			Candidate newCandidate = candidateRepository.findByUser(user);
			return new CandidateDetails(newCandidate.getId(), newCandidate.getDateOfBirth(), newCandidate.getGender(),
					newCandidate.getBio(), newCandidate.getCountry(), newCandidate.getCity(),
					newCandidate.getProfilePicture(), newCandidate.getResume());
		} else
			throw new UserDoesNotExistsException("The given id is not mapped to a User");
	}

	@Transactional
	public byte[] addResume(Candidate candidate) {
		candidateRepository.save(candidate);
		return candidateRepository.findByUser(candidate.getUser()).getResume();
	}

	@Transactional
	public byte[] addProfilePicture(Candidate candidate) {
		candidateRepository.save(candidate);
		return candidateRepository.findByUser(candidate.getUser()).getProfilePicture();
	}

}
