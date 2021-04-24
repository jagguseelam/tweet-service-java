package com.tweetapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.TweetLogger;
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
		TweetLogger.LOGGER.info("UserServiceImpl :: register");
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
		TweetLogger.LOGGER.info("UserServiceImpl :: getAllUsers");
		return userRepository.findAll();
	}

	@Override
	public User getUserDetails(String email) {
		TweetLogger.LOGGER.info("UserServiceImpl :: getUserDetails");
		return userRepository.findByEmail();
	}

	@Override
	public User login(UserLoginRequest userLoginRequest) throws UserNotFoundException {
		TweetLogger.LOGGER.info("UserServiceImpl :: login");
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
		TweetLogger.LOGGER.info("UserServiceImpl :: forgotPassword");
		User user = null;
		user = userRepository.findByLoginId(forgotPasswordRequest.getLoginId());
		if (user == null) {
			throw new UserNotFoundException();
		} else {
			return userRepositoryOperations.updatePassword(forgotPasswordRequest);
		}
	}

}
