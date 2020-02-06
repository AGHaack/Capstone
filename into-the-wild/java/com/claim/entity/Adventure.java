package com.claim.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="adventure")
public class Adventure implements Comparable<Adventure>
{
	@Id
	@Column(name="id")
	private int id;
	
	@OneToOne(fetch= FetchType.LAZY, optional= false)
	@JoinColumn(name="party_leader_email", referencedColumnName="email")
	private User partyLeader;
	
	@Column(name="adventure_name")
	private String name;
	
	@Column(name="park")
	private String park;
	
	@Column(name="activity")
	private String activity;
	
	@Column(name="lat_long")
	private String where;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="post")
	private String post;
	
	@Lob
	@Column(name="pic")
	private byte[] pic;
	
	@Column(name="post_date")
	private Date postDate;
	
	
	public Adventure()
	{
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPark() {
		return park;
	}


	public void setPark(String park) {
		this.park = park;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public User getPartyLeader() {
		return partyLeader;
	}


	public void setPartyLeader(User partyLeader) {
		this.partyLeader = partyLeader;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getActivity() {
		return activity;
	}


	public void setActivity(String activity) {
		this.activity = activity;
	}


	public String getWhere() {
		return where;
	}


	public void setWhere(String where) {
		this.where = where;
	}


	public byte[] getPic() {
		return pic;
	}


	public void setPic(byte[] pic) {
		this.pic = pic;
	}


	public Date getPostDate() {
		return postDate;
	}


	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	

	@Override
	public String toString() {
		return "Adventure [id=" + id + ", partyLeader=" + partyLeader + ", name=" + name + ", park=" + park
				+ ", activity=" + activity + ", where=" + where + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", post=" + post + ", pic=" + Arrays.toString(pic) + ", postDate=" + postDate + "]";
	}


	@Override
	public int compareTo(Adventure o) {
		
		return this.getPostDate().compareTo(o.getPostDate());
	}


}
