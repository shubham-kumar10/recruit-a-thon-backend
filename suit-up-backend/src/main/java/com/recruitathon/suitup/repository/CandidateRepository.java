package com.recruitathon.suitup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.dto.CandidateProfile;
import com.recruitathon.suitup.model.Candidate;
import com.recruitathon.suitup.model.User;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{

	Candidate findByUser(User user);
	boolean existsByUser(User user);
	List<CandidateProfile> findAllBy();
}
