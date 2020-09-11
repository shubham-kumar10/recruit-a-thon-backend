package com.recruitathon.suitup.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.recruitathon.suitup.dto.CandidateDetails;
import com.recruitathon.suitup.dto.CandidateProfile;
import com.recruitathon.suitup.exception.ApplicationAlreadyExistsException;
import com.recruitathon.suitup.exception.CandidateAlreadyExistException;
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

	public CandidateDetails candidateDetailsInit(Candidate candidate) {
		CandidateDetails details = new CandidateDetails(candidate.getId(), candidate.getDateOfBirth(), candidate.getGender(),
				candidate.getBio(), candidate.getCountry(), candidate.getCity(), candidate.getApplications(),
				candidate.getEducation(), candidate.getProject(), candidate.getExperience(), candidate.getSkills());
		if (candidate.getProfilePicture() != null && candidate.getProfilePicture().length > 0) {
			details.setProfilePicture(FileService.decompressBytes(candidate.getProfilePicture()));
		}
		if (candidate.getResume() != null && candidate.getResume().length > 0) {
			details.setResume(FileService.decompressBytes(candidate.getResume()));
		}
		return details;
	}

	public CandidateDetails getCandidateDetails(long id) throws CandidateDoesNotExistException {
		User user = userRepository.findById(id).get();
		Candidate candidate = candidateRepository.findByUser(user);
		if (candidate != null) {
			return candidateDetailsInit(candidate);
		} else {
			throw new CandidateDoesNotExistException("You have not added your details");
		}
	}

	public byte[] getProfilePicture(long id) {
		Candidate candidate = candidateRepository.findById(id).get();
		return FileService.decompressBytes(candidate.getProfilePicture());
	}

	public byte[] getResume(long id) {
		Candidate candidate = candidateRepository.findById(id).get();
		return FileService.decompressBytes(candidate.getResume());
	}

	@Transactional
	public CandidateDetails addDetails(Candidate candidate, long id)
			throws UserDoesNotExistsException, CandidateAlreadyExistException {
		if (!userRepository.findById(id).isPresent())
			throw new UserDoesNotExistsException("The given id is noSystem.out.println(candidate.getProfilePicture());t mapped to a User");
		else if (candidateRepository.existsByUser(userRepository.findById(id).get())) {
			throw new CandidateAlreadyExistException("Candidate details already exists for this user.");
		} else {
			candidate.setUser(userRepository.findById(id).get());
			candidateRepository.save(candidate);
			Candidate newCandidate = candidateRepository.findByUser(userRepository.findById(id).get());
			return candidateDetailsInit(newCandidate);
		}

	}

	@Transactional
	public Application withdrawApplication(long appId) {
		Application application = applicationRepository.findById(appId).get();
		application.setStatus("Withdrawn");
		application.setComplete(true);
		return applicationRepository.save(application);
	}

	@Transactional
	public CandidateDetails submitApplication(long canId, long jobId, String status)
			throws CandidateDoesNotExistException, JobDoesNotExistException, ApplicationAlreadyExistsException {
		if (!candidateRepository.findById(canId).isPresent()) {
			throw new CandidateDoesNotExistException("The is" + canId + "is not mapped with any existing candidate.");
		} else if (!jobRepository.findById(jobId).isPresent()) {
			throw new JobDoesNotExistException("There is not opening with Job as id" + jobId);
		} else {
			Candidate candidate = candidateRepository.findById(canId).get();
			Job job = jobRepository.findById(jobId).get();
			Application application;
			List<Application> applicationList;
			if (!applicationRepository.existsByJob(job)) {
				application = new Application(new Date(), status, false, 0.0, 0.0, job);
				applicationList = candidate.getApplications();
				applicationList.add(application);
				candidate.setApplications(applicationList);
				candidate = candidateRepository.save(candidate);
			} else {
				application = applicationRepository.findByJob(job);
				if (application.getStatus().equals("Saved") && status.equals("Applied")) {
					application.setStatus("Applied");
					application.setAppliedOn(new Date());
					candidate.getApplications().remove(candidate.getApplications().indexOf(application));
					applicationList = candidate.getApplications();
					applicationList.add(application);
					candidate.setApplications(applicationList);
				} else {
					throw new ApplicationAlreadyExistsException("You have already applied for this job.");
				}

			}
			return candidateDetailsInit(candidate);
		}
	}

	@Transactional
	public CandidateDetails uploadImage(MultipartFile file, long canId) throws IOException {
		Candidate candidate = candidateRepository.findById(canId).get();
		candidate.setProfilePicture(FileService.compressBytes(file.getBytes()));
		candidateRepository.save(candidate);
		CandidateDetails newCandidate = candidateDetailsInit(candidate);
		newCandidate.setProfilePicture(FileService.decompressBytes(candidate.getProfilePicture()));
		return newCandidate;
	}

	@Transactional
	public byte[] uploadResume(MultipartFile file, long canId) throws IOException {
		Candidate candidate = candidateRepository.findById(canId).get();
		candidate.setResume(FileService.compressBytes(file.getBytes()));
		candidateRepository.save(candidate);
		return getResume(candidate.getId());
	}

	public List<CandidateProfile> getAllCandidate() {
		return candidateRepository.findAllBy();
	}
}
