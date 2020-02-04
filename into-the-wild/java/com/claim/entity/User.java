package com.claim.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User 
{
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Id
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Lob
	@Column(name="profile_pic")
	private byte[] profilePic;
	@Column(name="age")
	private int age;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="park_count")
	private int parkCount;
	@Column(name="birthday")
	private Date birthday;

	
	
	public User()
	{
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(byte[] profilePic) {
		this.profilePic = profilePic;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getParkCount() {
		return parkCount;
	}

	public void setParkCount(int parkCount) {
		this.parkCount = parkCount;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public int calculateAge(Date bday) {
		LocalDate today = LocalDate.now();
		ZoneId zId = ZoneId.systemDefault();
		Instant instant = bday.toInstant();
		LocalDate bdayLocal = instant.atZone(zId).toLocalDate();
		int age = Period.between(bdayLocal, today).getYears();
		
		return age;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", profilePic=" + Arrays.toString(profilePic) + ", age=" + age + ", city=" + city + ", state=" + state
				+ ", parkCount=" + parkCount + ", birthday=" + birthday + "]";
	}

	
}


