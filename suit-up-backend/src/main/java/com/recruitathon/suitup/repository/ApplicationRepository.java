package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.Application;
import com.recruitathon.suitup.model.Job;

public interface ApplicationRepository extends JpaRepository<Application, Long>{

	Application findByJob(Job job);
	boolean existsByJob(Job job);

}
