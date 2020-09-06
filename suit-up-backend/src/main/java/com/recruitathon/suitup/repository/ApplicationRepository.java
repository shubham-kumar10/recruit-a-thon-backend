package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{

}
