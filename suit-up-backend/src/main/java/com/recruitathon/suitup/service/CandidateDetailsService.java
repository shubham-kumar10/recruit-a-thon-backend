package com.recruitathon.suitup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitathon.suitup.model.Education;
import com.recruitathon.suitup.model.Experience;
import com.recruitathon.suitup.model.Project;
import com.recruitathon.suitup.model.Skills;
import com.recruitathon.suitup.repository.CertificateRepository;
import com.recruitathon.suitup.repository.EducationRepository;
import com.recruitathon.suitup.repository.ExperienceRepository;
import com.recruitathon.suitup.repository.ProjectRepository;
import com.recruitathon.suitup.repository.SkillsRepository;

@Service
public class CandidateDetailsService {

	@Autowired
	ExperienceRepository experienceRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	CertificateRepository certificateRepository;
	
	@Autowired
	EducationRepository educationRepository;
	
	@Autowired
	SkillsRepository skillsRepository;
	
	public Experience addExperience(Experience experience) {
		return experienceRepository.save(experience);
	}

	public Project addProject(Project project) {
		return projectRepository.save(project);
	}

	public Education addEducation(Education education) {
		return educationRepository.save(education);
	}

	public Skills addSkills(Skills skills) {
		return skillsRepository.save(skills);
	}
}
