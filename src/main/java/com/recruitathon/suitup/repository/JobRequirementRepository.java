package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.JobRequirement;

public interface JobRequirementRepository extends JpaRepository<JobRequirement, Long> {

}
