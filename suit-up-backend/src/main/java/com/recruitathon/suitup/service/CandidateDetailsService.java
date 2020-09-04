package com.recruitathon.suitup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitathon.suitup.dto.EducationDetails;
import com.recruitathon.suitup.dto.ExperienceDetails;
import com.recruitathon.suitup.dto.ProjectDetails;
import com.recruitathon.suitup.dto.SkillDetails;
import com.recruitathon.suitup.model.Candidate;
import com.recruitathon.suitup.model.Education;
import com.recruitathon.suitup.model.Experience;
import com.recruitathon.suitup.model.Project;
import com.recruitathon.suitup.model.Skills;
import com.recruitathon.suitup.repository.CandidateRepository;
import com.recruitathon.suitup.repository.CertificateRepository;
import com.recruitathon.suitup.repository.EducationRepository;
import com.recruitathon.suitup.repository.ExperienceRepository;
import com.recruitathon.suitup.repository.ProjectRepository;
import com.recruitathon.suitup.repository.SkillsRepository;

@Service
public class CandidateDetailsService {

	@Autowired
	CandidateRepository candidateRepository;

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

	public Experience addExperience(ExperienceDetails experience, long id) {
		Candidate candidate = candidateRepository.findById(id).get();
		Experience entity = new Experience(candidate, experience.getOrganization(), experience.getStartDate(),
				experience.getEndDate(), experience.getDesignation(), experience.getType(), experience.getLocation());
		return experienceRepository.save(entity);
	}

	public Project addProject(ProjectDetails project, long id) {
		Candidate candidate = candidateRepository.findById(id).get();
		Project entity = new Project(project.getName(), project.getDescription(), project.getStartDate(),
				project.getEndDate(), project.isOngoing(), candidate);
		return projectRepository.save(entity);
	}

	public Education addEducation(EducationDetails education, long id) {
		Candidate candidate = candidateRepository.findById(id).get();
		Education entity = new Education(candidate, education.getInstitution(), education.getStartDate(),
				education.getEndDate(), education.getDegree(), education.getDescription());
		return educationRepository.save(entity);
	}

	public Skills addSkills(SkillDetails skills, long id) {
		Candidate candidate = candidateRepository.findById(id).get();
		Skills entity = new Skills(candidate, skills.getSkillName(), skills.getRating());
		return skillsRepository.save(entity);
	}
}
