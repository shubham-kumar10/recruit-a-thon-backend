package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.Candidate;
import com.recruitathon.suitup.model.User;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

	Candidate findByUser(User user);
	
}
