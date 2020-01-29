package com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.entity.UserNotification;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Integer>
{

}
