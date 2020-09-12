package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
