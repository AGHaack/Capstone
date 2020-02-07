package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claim.entity.Message;
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
	
	@Query(value="select * from message where to_email = :email", nativeQuery= true)
	List<Message> findMyIncomingMessages(String email);
	
	@Query(value="select * from message where from_email = :email", nativeQuery= true)
	List<Message> findMyOutGoingMessages(String email);
}
