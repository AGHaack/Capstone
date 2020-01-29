package com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.entity.PartyMember;

@Repository
public interface PartyMemberRepository extends JpaRepository<PartyMember, Integer>
{

}
