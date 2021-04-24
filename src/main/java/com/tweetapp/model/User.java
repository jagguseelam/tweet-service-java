package com.tweetapp.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Seelam Jagadeeswara Reddy
 *
 */
@Document(collection = "User")
@TypeAlias("User")
public class User {
	@JsonIgnore
	private String id;
	@JsonIgnore
	private String loginId;
	@JsonIgnore
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNumber;
	@JsonIgnore
	private Date userCreatedTime;
	@JsonIgnore
	private Date lastUpdatedTime;

	private List<String> notifications;

	public List<String> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<String> notifications) {
		this.notifications = notifications;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getUserCreatedTime() {
		return userCreatedTime;
	}

	public void setUserCreatedTime(Date userCreatedTime) {
		this.userCreatedTime = userCreatedTime;
	}

}
