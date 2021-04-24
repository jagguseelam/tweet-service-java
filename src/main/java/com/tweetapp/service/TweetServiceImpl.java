package com.tweetapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.model.AddTweetRequest;
import com.tweetapp.model.ReplyTweetRequest;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.UpdateTweetRequest;
import com.tweetapp.repository.TweetRepository;
import com.tweetapp.repository.TweetRepositoryOperations;
import com.tweetapp.util.TweetConstants;

/**
 * @author Seelam Jagadeeswara Reddy
 *
 */
@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetRepository tweetRepository;

	@Autowired
	private TweetRepositoryOperations tweetRepositoryOperations;

	@Override
	public List<Tweet> getAllTweets() {
		return tweetRepository.findAll();
	}

	@Override
	public List<Tweet> getAllTweets(String loginId) {
		return tweetRepository.findByLoginId(loginId);
	}

	@Override
	public String addTweet(AddTweetRequest addTweetRequest) {
		boolean isTweetAdded = tweetRepositoryOperations.addTweet(addTweetRequest);
		if (isTweetAdded) {
			return TweetConstants.SUCCESS;
		} else {
			return TweetConstants.FAIL;
		}
	}

	@Override
	public String updateTweet(UpdateTweetRequest updateTweetRequest) {
		boolean isTweetUpdated = tweetRepositoryOperations.updateTweet(updateTweetRequest);
		if (isTweetUpdated) {
			return TweetConstants.SUCCESS;
		} else {
			return TweetConstants.FAIL;
		}

	}

	@Override
	public String deleteTweet(String tweetId) {
		boolean isTweetDeleted = tweetRepositoryOperations.deleteTweet(tweetId);
		if (isTweetDeleted) {
			return TweetConstants.SUCCESS;
		} else {
			return TweetConstants.FAIL;
		}
	}

	@Override
	public String likeTweet(String tweetId, String loginId) {
		boolean isTweetLiked = tweetRepositoryOperations.likeTweet(tweetId, loginId);
		if (isTweetLiked) {
			return TweetConstants.SUCCESS;
		} else {
			return TweetConstants.FAIL;
		}
	}

	@Override
	public String replyTweet(ReplyTweetRequest replyTweetRequest) {
		boolean isTweetReplied = tweetRepositoryOperations.replyTweet(replyTweetRequest);
		if (isTweetReplied) {
			return TweetConstants.SUCCESS;
		} else {
			return TweetConstants.FAIL;
		}
	}

}
