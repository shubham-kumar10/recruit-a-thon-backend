package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience,Integer>{

	//List<Experience> findByCandidate(Candidate candidate);
}
