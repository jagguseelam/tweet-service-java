package com.tweetapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.exception.UserAlreadyExistsException;
import com.tweetapp.exception.UserNotFoundException;
import com.tweetapp.model.ForgotPasswordRequest;
import com.tweetapp.model.User;
import com.tweetapp.model.UserLoginRequest;
import com.tweetapp.repository.UserRepository;
import com.tweetapp.repository.UserRepositoryOperations;

/**
 * @author Seelam Jagadeeswara Reddy
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRepositoryOperations userRepositoryOperations;

	@Override
	public boolean register(User user) throws UserAlreadyExistsException {
		boolean isRegistered = false;
		User checkUser = userRepository.findByLoginIdAndEmail(user.getLoginId(), user.getEmail());
		if (checkUser == null) {
			user.setUserCreatedTime(new Date());
			userRepository.save(user);
			isRegistered = true;
		} else {
			throw new UserAlreadyExistsException();
		}
		return isRegistered;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserDetails(String email) {
		return userRepository.findByEmail();
	}

	@Override
	public User login(UserLoginRequest userLoginRequest) throws UserNotFoundException {
		User user = null;
		user = userRepository.findByLoginIdAndPassword(userLoginRequest.getLoginId(), userLoginRequest.getPassword());
		if (user == null) {
			throw new UserNotFoundException();
		} else {
			return user;
		}
	}

	@Override
	public boolean forgotPassword(ForgotPasswordRequest forgotPasswordRequest) throws UserNotFoundException {
		User user = null;
		user = userRepository.findByLoginId(forgotPasswordRequest.getLoginId());
		if (user == null) {
			throw new UserNotFoundException();
		} else {
			return userRepositoryOperations.updatePassword(forgotPasswordRequest);
		}
	}

}
