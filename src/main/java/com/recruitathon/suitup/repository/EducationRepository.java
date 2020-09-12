package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.Education;

public interface EducationRepository extends JpaRepository<Education, Integer> {

}
