package com.tweetapp.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Seelam Jagadeeswara Reddy
 *
 */
@Document(collection = "Tweet")
@TypeAlias("Tweet")
public class Tweet {

	String _id;
	String name;
	String loginId;
	String description;
	String postedBy;
	Date postedTime;
	Date lastUpdatedTime;
	ArrayList<Likes> likes;
	ArrayList<Comments> comments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

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

	public ArrayList<Likes> getLikes() {
		return likes;
	}

	public void setLikes(ArrayList<Likes> likes) {
		this.likes = likes;
	}

	public ArrayList<Comments> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comments> comments) {
		this.comments = comments;
	}

}
