package com.recruitathon.suitup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitathon.suitup.exception.CandidateDoesNotExistException;
import com.recruitathon.suitup.exception.JobDoesNotExistException;
import com.recruitathon.suitup.model.Application;
import com.recruitathon.suitup.service.CandidateService;

@RestController
public class ApplicationController {

	@Autowired
	CandidateService candidateService;

	@PostMapping("/apply/{canId}/{jobId}")
	public boolean submitApplication(@PathVariable long canId, @PathVariable long jobId)
			throws CandidateDoesNotExistException, JobDoesNotExistException {
		return candidateService.submitApplication(canId, jobId);
	}
	
	@PostMapping("/widthdraw/{appId}")
	public Application withdrawApplication(@PathVariable long appId)
			throws CandidateDoesNotExistException, JobDoesNotExistException {
		return candidateService.withdrawApplication(appId);
	}
}
