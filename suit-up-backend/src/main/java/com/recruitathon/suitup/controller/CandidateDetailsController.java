package com.recruitathon.suitup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitathon.suitup.model.Education;
import com.recruitathon.suitup.model.Experience;
import com.recruitathon.suitup.model.Project;
import com.recruitathon.suitup.model.Skills;
import com.recruitathon.suitup.service.CandidateDetailsService;

@RestController("edit")
public class CandidateDetailsController {

	@Autowired
	CandidateDetailsService candidateDetailsService;
	
	@PostMapping("/experience")
	public Experience addExperience(@RequestBody Experience experience){
		return candidateDetailsService.addExperience(experience);
	}
	
	@PostMapping("/project")
	public Project addProject(@RequestBody Project project){
		return candidateDetailsService.addProject(project);
	}
	
	@PostMapping("/education")
	public Education addEducation(@RequestBody Education education){
		return candidateDetailsService.addEducation(education);
	}
	
	@PostMapping("/skills")
	public Skills addSkills(@RequestBody Skills skills){
		return candidateDetailsService.addSkills(skills);
	}
}
