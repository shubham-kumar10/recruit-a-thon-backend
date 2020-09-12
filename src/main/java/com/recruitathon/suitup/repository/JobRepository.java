package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
