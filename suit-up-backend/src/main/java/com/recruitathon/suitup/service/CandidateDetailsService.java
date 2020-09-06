package com.recruitathon.suitup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
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

	public List<Experience> addExperience(List<Experience> experienceList, long id) {
		Candidate candidate = candidateRepository.findById(id).get();
		candidate.setExperience(experienceList);
		candidateRepository.save(candidate);
		return candidateRepository.findById(id).get().getExperience();
	}

	public List<Project> addProject(List<Project> projectList, long id) {
		Candidate candidate = candidateRepository.findById(id).get();
		candidate.setProject(projectList);
		candidateRepository.save(candidate);
		return candidateRepository.findById(id).get().getProject();
	}

	public List<Education> addEducation(List<Education> educationList, long id) {
		Candidate candidate = candidateRepository.findById(id).get();
		candidate.setEducation(educationList);
		candidateRepository.save(candidate);
		return candidateRepository.findById(id).get().getEducation();
	}

	public List<Skills> addSkills(List<Skills> skillList, long id) {
		Candidate candidate = candidateRepository.findById(id).get();
		candidate.setSkills(skillList);
		candidateRepository.save(candidate);
		return candidateRepository.findById(id).get().getSkills();
	}
	
}
