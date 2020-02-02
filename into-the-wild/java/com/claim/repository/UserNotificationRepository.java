package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claim.entity.UserNotification;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Integer>
{
	@Query(value="Select * from UserNotification where to_email = :email", nativeQuery= true)
	List<UserNotification> findMyNotifications(String email);
}
