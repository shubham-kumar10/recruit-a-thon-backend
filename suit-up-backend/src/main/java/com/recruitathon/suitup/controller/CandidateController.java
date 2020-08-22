package com.recruitathon.suitup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitathon.suitup.model.Candidate;
import com.recruitathon.suitup.service.CandidateService;

@RestController
@RequestMapping("/profile")
public class CandidateController {
	
	@Autowired
	CandidateService candidateService;

	@GetMapping("/{username}")
	public Candidate getCandidateDetails(@PathVariable String username) {
		return candidateService.getCandidateDetails(username);
	}
	
	@PostMapping
	public Candidate addDetails(@RequestBody Candidate candidate) {
		return candidateService.addDetails(candidate);
	}
}
