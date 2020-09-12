package com.recruitathon.suitup.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.recruitathon.suitup.dto.CandidateDetails;
import com.recruitathon.suitup.dto.ProfileDTO;
import com.recruitathon.suitup.exception.CandidateAlreadyExistException;
import com.recruitathon.suitup.exception.CandidateDoesNotExistException;
import com.recruitathon.suitup.exception.UserDoesNotExistsException;
import com.recruitathon.suitup.model.Candidate;
import com.recruitathon.suitup.service.CandidateService;

@RestController
@RequestMapping("/profile")
public class CandidateController {

	@Autowired
	CandidateService candidateService;

	@GetMapping("/{userId}")
	public CandidateDetails getCandidateDetails(@PathVariable long userId) throws CandidateDoesNotExistException {
		return candidateService.getCandidateDetails(userId);
	}

	@PostMapping("/{id}")
	public CandidateDetails addDetails(@RequestBody Candidate candidate, @PathVariable long id)
			throws UserDoesNotExistsException, CandidateAlreadyExistException {
		return candidateService.addDetails(candidate, id);
	}

	@PostMapping("/image/{canId}")
	public CandidateDetails addProfilePicture(@PathVariable long canId, @RequestParam("imageFile") MultipartFile file)
			throws IOException {
		return candidateService.uploadImage(file, canId);
	}

	@PostMapping("/resume/{canId}")
	public byte[] addResume(@PathVariable long canId, @RequestParam("imageFile") MultipartFile file)
			throws IOException {
		return candidateService.uploadResume(file, canId);
	}
	
	@GetMapping("/image/{canId}")
	public byte[] getProfilePicture(@PathVariable long canId) {
		return candidateService.getProfilePicture(canId);
	}
	
	@GetMapping("/resume/{canId}")
	public byte[] getResume(@PathVariable long canId) {
		return candidateService.getResume(canId);
	}
	
	@GetMapping("/all")
	public List<ProfileDTO> getAllCandidates(){
		return candidateService.getAllCandidate();
	}
}
