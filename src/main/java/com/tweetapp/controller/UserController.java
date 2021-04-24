package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.exception.UserAlreadyExistsException;
import com.tweetapp.exception.UserNotFoundException;
import com.tweetapp.model.ForgotPasswordRequest;
import com.tweetapp.model.User;
import com.tweetapp.model.UserLoginRequest;
import com.tweetapp.service.UserService;
import com.tweetapp.util.TweetConstants;

/**
 * @author Seelam Jagadeeswara Reddy
 *
 */
@RestController()
@RequestMapping("/api/v1.0/tweets")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/register")
	public String register(@RequestBody User user) throws UserAlreadyExistsException {
		boolean isRegistered = userService.register(user);
		if (isRegistered) {
			return TweetConstants.SUCCESS;
		} else {
			return TweetConstants.FAIL;
		}
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{user}")
	public User getUserDetails(@PathVariable String email) {
		return userService.getUserDetails(email);
	}

	@PostMapping("/user/login")
	public User login(@RequestBody UserLoginRequest userLoginRequest) throws UserNotFoundException {
		return userService.login(userLoginRequest);
	}

	@PostMapping("/user/forgot")
	public String forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest)
			throws UserNotFoundException {
		boolean isPasswordChanged = userService.forgotPassword(forgotPasswordRequest);
		if (isPasswordChanged) {
			return TweetConstants.SUCCESS;
		} else {
			return TweetConstants.FAIL;
		}
	}

}
