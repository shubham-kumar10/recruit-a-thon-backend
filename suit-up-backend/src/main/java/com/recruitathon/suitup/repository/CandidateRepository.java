package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

}
