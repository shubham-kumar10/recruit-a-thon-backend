package com.recruitathon.suitup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recruitathon.suitup.dto.ProfileDTO;
import com.recruitathon.suitup.model.Candidate;
import com.recruitathon.suitup.model.User;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	Candidate findByUser(User user);

	boolean existsByUser(User user);

//	@Query("select new com.recruitathon.suitup.dto.ProfileDTO(c.city, c.country, c.profilePicture, c.skills,c.experience, c.user.firstName,c.user.lastName, c.user.id, c.user.contactNumber, c.user.userName)"
//			+  "from Candidate c")
//	
//
//	List<ProfileDTO> findAllBy();

	@Query("select new com.recruitathon.suitup.dto.ProfileDTO(c.city, c.country,c.profilePicture,c.user.firstName,c.user.lastName, c.user.id, c.user.contactNumber, c.user.userName)"
			+ "from Candidate c")

	List<ProfileDTO> findAllBy();

}
