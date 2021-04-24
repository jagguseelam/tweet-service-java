package com.tweetapp.model;

import java.util.Date;

/**
 * @author Seelam Jagadeeswara Reddy
 *
 */
public class Likes {
	String likedBy;
	Date likedTime;

	public String getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(String likedBy) {
		this.likedBy = likedBy;
	}

	public Date getLikedTime() {
		return likedTime;
	}

	public void setLikedTime(Date likedTime) {
		this.likedTime = likedTime;
	}

}
