package com.claim.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message implements Comparable<Message> {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="sent_date")
	private Date sent;
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="to_email", referencedColumnName="email")
	private User to;
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="from_email", referencedColumnName="email")
	private User from;
	@Column(name="seen")
	private boolean seen;
	@Column(name="message")
	private String message;
	
	
	public Message() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getSent() {
		return sent;
	}

	public void setSent(Date sent) {
		this.sent = sent;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sent=" + sent + ", to=" + to + ", from=" + from + ", seen=" + seen
				+ ", message=" + message + "]";
	}

	@Override
	public int compareTo(Message o) {
		
		return this.getSent().compareTo(o.getSent());
	}
	
}
