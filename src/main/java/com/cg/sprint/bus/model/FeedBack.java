package com.cg.sprint.bus.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback_table")
public class FeedBack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedBackId;
	
	@Column
	private int driverRating;
	
	@Column
	private int serviceRating;
	
	@Column
	private int overallRating;
	
	@Column
	private String comments;
	
	@Column
	private LocalDate feedBackDate = LocalDate.now();
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "userId")
    private User user;

    @OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "busId")
	private Bus bus;
    
    public FeedBack() {
    	super();
    }

	public FeedBack(int feedBackId, int driverRating, int serviceRating, int overallRating, String comments,
			LocalDate feedBackDate, User user) {
		super();
		this.feedBackId = feedBackId;
		this.driverRating = driverRating;
		this.serviceRating = serviceRating;
		this.overallRating = overallRating;
		this.comments = comments;
		this.feedBackDate = feedBackDate;
		this.user = user;
	}

	public FeedBack(int feedBackId, int driverRating, int serviceRating, int overallRating, String comments,
			LocalDate feedBackDate, User user, Bus bus) {
		super();
		this.feedBackId = feedBackId;
		this.driverRating = driverRating;
		this.serviceRating = serviceRating;
		this.overallRating = overallRating;
		this.comments = comments;
		this.feedBackDate = feedBackDate;
		this.user = user;
		this.bus = bus;
	}

	public int getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}

	public int getDriverRating() {
		return driverRating;
	}

	public void setDriverRating(int driverRating) {
		this.driverRating = driverRating;
	}

	public int getServiceRating() {
		return serviceRating;
	}

	public void setServiceRating(int serviceRating) {
		this.serviceRating = serviceRating;
	}

	public int getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getFeedBackDate() {
		return feedBackDate;
	}

	public void setFeedbackdate(LocalDate feedBackDate) {
		this.feedBackDate = feedBackDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Feedback [feedBackId=" + feedBackId + ", driverRating=" + driverRating + ", serviceRating="
				+ serviceRating + ", overallRating=" + overallRating + ", comments=" + comments + ", feedBackDate="
				+ feedBackDate + ", user=" + user + ", bus=" + bus + "]";
	}
    
	
}
