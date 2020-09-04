package com.recruitathon.suitup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitathon.suitup.dto.EducationDetails;
import com.recruitathon.suitup.dto.ExperienceDetails;
import com.recruitathon.suitup.dto.ProjectDetails;
import com.recruitathon.suitup.dto.SkillDetails;
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
	public Experience addExperience(@RequestBody ExperienceDetails experience, @PathVariable long id) {
		return candidateDetailsService.addExperience(experience, id);
	}

	@PostMapping("/project")
	public Project addProject(@RequestBody ProjectDetails project, @PathVariable long id) {
		return candidateDetailsService.addProject(project, id);
	}

	@PostMapping("/education")
	public Education addEducation(@RequestBody EducationDetails education, @PathVariable long id) {
		return candidateDetailsService.addEducation(education, id);
	}

	@PostMapping("/skills")
	public Skills addSkills(@RequestBody SkillDetails skills, @PathVariable long id) {
		return candidateDetailsService.addSkills(skills, id);
	}

}
