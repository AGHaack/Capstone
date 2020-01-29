
package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.entity.Adventure;
import com.claim.entity.User;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Integer>
{
	@Query(value= "Select * from Adventure where party_leader_email = :email", nativeQuery= true)
	List<Adventure> findPartyLeaderAdventures(String email);
}
