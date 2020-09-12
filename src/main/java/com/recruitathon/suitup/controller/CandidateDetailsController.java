package com.recruitathon.suitup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitathon.suitup.model.Education;
import com.recruitathon.suitup.model.Experience;
import com.recruitathon.suitup.model.Project;
import com.recruitathon.suitup.model.Skills;
import com.recruitathon.suitup.service.CandidateDetailsService;

@RestController
@RequestMapping("edit/{id}")
public class CandidateDetailsController {

	@Autowired
	CandidateDetailsService candidateDetailsService;

	@PostMapping("/experience")
	public List<Experience> addExperience(@RequestBody List<Experience> experience, @PathVariable long id) {
		return candidateDetailsService.addExperience(experience, id);
	}

	@PostMapping("/project")
	public List<Project> addProject(@RequestBody List<Project> project, @PathVariable long id) {
		return candidateDetailsService.addProject(project, id);
	}

	@PostMapping("/education")
	public List<Education> addEducation(@RequestBody List<Education> education, @PathVariable long id) {
		return candidateDetailsService.addEducation(education, id);
	}

	@PostMapping("/skills")
	public List<Skills> addSkills(@RequestBody List<Skills> skills, @PathVariable long id) {
		return candidateDetailsService.addSkills(skills, id);
	}

}
