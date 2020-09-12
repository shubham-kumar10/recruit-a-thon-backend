package com.recruitathon.suitup.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitathon.suitup.model.Job;
import com.recruitathon.suitup.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	JobRepository jobRepository;
	
	public List<Job> getAllJobs(){
		return jobRepository.findAll();
	}
	
	public Job getJob(long id) {
		return jobRepository.findById(id).get();
	}
	
	@Transactional
	public Job addJob(Job job) {
		return jobRepository.save(job);
	}
}
