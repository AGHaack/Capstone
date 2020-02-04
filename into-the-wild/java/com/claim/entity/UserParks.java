package com.claim.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_parks")
public class UserParks {
	@Id
	@Column(name="id")
	private int id;
	@OneToOne(fetch= FetchType.LAZY, optional = false)
	@JoinColumn(name="user_key", referencedColumnName="email")
	private User userKey;
	@Column(name="park")
	private String park;
	@Column(name="visited")
	private Date visited;
	
	public UserParks() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserKey() {
		return userKey;
	}

	public void setUserKey(User userKey) {
		this.userKey = userKey;
	}

	public String getPark() {
		return park;
	}

	public void setPark(String park) {
		this.park = park;
	}

	public Date getVisited() {
		return visited;
	}

	public void setVisited(Date visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		return "UserParks [id=" + id + ", userKey=" + userKey + ", park=" + park + "]";
	}
	
}
