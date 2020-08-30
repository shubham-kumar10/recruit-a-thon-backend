package com.recruitathon.suitup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitathon.suitup.model.Job;
import com.recruitathon.suitup.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	JobService jobService;
	
	@GetMapping
	public List<Job> getAllJobs(){
		return jobService.getAllJobs();
	}
	
	@GetMapping("/{id}")
	public Job getJobById(@PathVariable long id) {
		return jobService.getJob(id);
	}
	
	@PostMapping
	public Job addJob(@RequestBody Job job) {
		return jobService.addJob(job);
	}
}
