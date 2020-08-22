package com.recruitathon.suitup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruitathon.suitup.model.User;



public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);
	User findById(Long id);
	boolean existsByUserName(String username);

}
