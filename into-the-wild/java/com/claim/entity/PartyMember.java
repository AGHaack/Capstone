package com.claim.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="adventure_party_members")
public class PartyMember 
{
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(fetch= FetchType.LAZY, optional= false)
	@JoinColumn(name= "adventure_id", referencedColumnName= "id", nullable= false)
	private Adventure adventure;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="party_member_email", referencedColumnName="email")
	private User partyMember;
	@Column(name="date_joined")
	private Date dateJoined;
	
	public PartyMember()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getPartyMember() {
		return partyMember;
	}

	public void setPartyMember(User partyMember) {
		this.partyMember = partyMember;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public Adventure getAdventure() {
		return adventure;
	}

	public void setAdventure(Adventure adventure) {
		this.adventure = adventure;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
