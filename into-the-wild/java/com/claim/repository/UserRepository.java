package com.claim.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
	
	@Query("Select U from User U where U.email = :email")
	User findUser(@Param("email") String email);
	
	@Query("Select U from User U where U.email = :email and U.password = :password")
	Optional<User> login(@Param("email") String email, @Param("password") String password);
}
