package com.recruitathon.suitup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.Candidate;
import com.recruitathon.suitup.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience,Integer>{

	//List<Experience> findByCandidate(Candidate candidate);
}
