package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.User;



public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String username);
	boolean existsByUserName(String username);
}
