package com.recruitathon.suitup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitathon.suitup.dto.CandidateDetails;
import com.recruitathon.suitup.exception.ApplicationAlreadyExistsException;
import com.recruitathon.suitup.exception.CandidateDoesNotExistException;
import com.recruitathon.suitup.exception.JobDoesNotExistException;
import com.recruitathon.suitup.model.Application;
import com.recruitathon.suitup.service.CandidateService;

@CrossOrigin(origins = "*")
@RestController
public class ApplicationController {

	@Autowired
	CandidateService candidateService;

	@PostMapping("/apply/{canId}/{jobId}")
	public CandidateDetails submitApplication(@PathVariable long canId, @PathVariable long jobId)
			throws CandidateDoesNotExistException, JobDoesNotExistException, ApplicationAlreadyExistsException {
		return candidateService.submitApplication(canId, jobId,"Applied");
	}
	
	@PostMapping("/widthdraw/{appId}")
	public Application withdrawApplication(@PathVariable long appId)
			throws CandidateDoesNotExistException, JobDoesNotExistException {
		return candidateService.withdrawApplication(appId);
	}
	
	@PostMapping("/save/{canId}/{jobId}")
	public CandidateDetails saveApplication(@PathVariable long canId, @PathVariable long jobId)
			throws CandidateDoesNotExistException, JobDoesNotExistException, ApplicationAlreadyExistsException {
		return candidateService.submitApplication(canId, jobId,"Saved");
	}
	
	@GetMapping("/compare")
	public void compareApplications() {
		
	}
	
	@GetMapping("applications/get")
	public String testEndpoint(){
		return "API is running";
	}
}
