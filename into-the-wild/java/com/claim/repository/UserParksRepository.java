package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claim.entity.UserParks;
@Repository
public interface UserParksRepository extends JpaRepository<UserParks, Integer> {
	
	@Query(value= "Select * from user_parks where user_key = :email", nativeQuery = true)
	List<UserParks> findUserParks(String email);
}
