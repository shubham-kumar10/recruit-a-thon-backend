package com.recruitathon.suitup.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recruitathon.suitup.dto.CandidateDetails;
import com.recruitathon.suitup.exception.CandidateDoesNotExistException;
import com.recruitathon.suitup.exception.JobDoesNotExistException;
import com.recruitathon.suitup.exception.UserDoesNotExistsException;
import com.recruitathon.suitup.model.Application;
import com.recruitathon.suitup.model.Candidate;
import com.recruitathon.suitup.model.Job;
import com.recruitathon.suitup.model.User;
import com.recruitathon.suitup.repository.ApplicationRepository;
import com.recruitathon.suitup.repository.CandidateRepository;
import com.recruitathon.suitup.repository.JobRepository;
import com.recruitathon.suitup.repository.UserRepository;

@Service
public class CandidateService {

	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ApplicationRepository applicationRepository;

	@Autowired
	JobRepository jobRepository;

	@Autowired
	CandidateDetailsService candidateDetails;

	public CandidateDetails getCandidateDetails(long id) {
		User user = userRepository.findById(id).get();
		Candidate candidate = candidateRepository.findByUser(user);
		CandidateDetails candidateDetails = new CandidateDetails(candidate.getId(), candidate.getDateOfBirth(),
				candidate.getGender(), candidate.getBio(), candidate.getCountry(), candidate.getCity(),
				candidate.getProfilePicture(), candidate.getResume(), candidate.getEducation(), candidate.getProject(),
				candidate.getExperience(), candidate.getSkills());
		return candidateDetails;
	}

	@Transactional
	public CandidateDetails addDetails(Candidate candidate, long id) throws UserDoesNotExistsException {
		User user = userRepository.findById(id).get();
		if (user != null) {
			candidate.setUser(user);
			candidateRepository.save(candidate);
			Candidate newCandidate = candidateRepository.findByUser(user);
			return new CandidateDetails(newCandidate.getId(), newCandidate.getDateOfBirth(), newCandidate.getGender(),
					newCandidate.getBio(), newCandidate.getCountry(), newCandidate.getCity(),
					newCandidate.getProfilePicture(), newCandidate.getResume(), newCandidate.getEducation(),
					newCandidate.getProject(), newCandidate.getExperience(), newCandidate.getSkills());
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

	@Transactional
	public boolean submitApplication(long canId, long jobId)
			throws CandidateDoesNotExistException, JobDoesNotExistException {
		Optional<Candidate> opCandidate = candidateRepository.findById(canId);
		Optional<Job> job = jobRepository.findById(jobId);
		if (!opCandidate.isPresent()) {
			throw new CandidateDoesNotExistException("The is" + canId + "is not mapped with any existing candidate.");
		} else if (!job.isPresent()) {
			throw new JobDoesNotExistException("There is not opening with Job as id" + jobId);
		} else {
			Application application = new Application(new Date(), "Applied", false, 0.0, 0.0, job.get());
			Candidate candidate = opCandidate.get();
			List<Application> applicationList = candidate.getApplications();
			applicationList.add(application);
			candidate.setApplications(applicationList);
			candidateRepository.save(candidate);
			return true;
		}
	}

	public Application withdrawApplication(long appId) {
		Application application = applicationRepository.findById(appId).get();
		application.setStatus("Withdrawn");
		application.setComplete(true);
		return applicationRepository.save(application);
	}

}
