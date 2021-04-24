package com.tweetapp.model;

import java.util.Date;

/**
 * @author Seelam Jagadeeswara Reddy
 *
 */
public class Comments {
	String description;
	String postedBy;
	Date postedTime;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public Date getPostedTime() {
		return postedTime;
	}

	public void setPostedTime(Date postedTime) {
		this.postedTime = postedTime;
	}

}
