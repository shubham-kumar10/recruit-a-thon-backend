package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.Applications;

public interface ApplicationsRepository extends JpaRepository<Applications, Integer>{

}
