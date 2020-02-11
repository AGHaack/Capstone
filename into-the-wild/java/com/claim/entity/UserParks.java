package com.claim.entity;

import java.util.Comparator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_parks")
public class UserParks implements Comparator<UserParks>{
	@Id
	@Column(name="id")
	private int id;
	@OneToOne(fetch= FetchType.LAZY, optional = false)
	@JoinColumn(name="user_key", referencedColumnName="email")
	private User userKey;
	@Column(name="park")
	private String parkName;
	@Column(name="park_code")
	private String parkCode;
	@Column(name="visited")
	private int visited;
	@Column(name="activity")
	private String activity;
	@Column(name="location")
	private String location;
	
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

	public int getVisited() {
		return visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}
	
	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean checkVisited(List<UserParks> parks, String newPark) {
		boolean hasVisited = false;
		for(UserParks p : parks) {
			String oldPark = p.getParkName();
			if(!oldPark.equals(newPark)) {
				hasVisited = false;
			}
			else {
				hasVisited = true;
				break;
			}
		}
		return hasVisited;
	}

	@Override
	public String toString() {
		return "UserParks [id=" + id + ", userKey=" + userKey + ", parkName=" + parkName + ", parkCode=" + parkCode
				+ ", visited=" + visited + ", activity=" + activity + ", location=" + location + "]";
	}

	@Override
	public int compare(UserParks o1, UserParks o2) {
		return o1.getVisited() - o2.getVisited();
	}



	
}
