package com.tweetapp.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.tweetapp.model.AddTweetRequest;
import com.tweetapp.model.Comments;
import com.tweetapp.model.Likes;
import com.tweetapp.model.ReplyTweetRequest;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.UpdateTweetRequest;

/**
 * @author Seelam Jagadeeswara Reddy
 *
 */
@Component
public class TweetRepositoryOperationsImpl implements TweetRepositoryOperations {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public boolean addTweet(AddTweetRequest addTweetRequest) {
		Tweet addTweet = new Tweet();
		addTweet.setDescription(addTweetRequest.getDescription());
		addTweet.setLoginId(addTweetRequest.getLoginId());
		addTweet.setPostedBy(addTweetRequest.getPostedBy());
		addTweet.setPostedTime(new Date());

		try {
			mongoTemplate.insert(addTweet);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateTweet(UpdateTweetRequest updateTweetRequest) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(updateTweetRequest.getTweetId()));

		Update updateTweet = new Update().set("description", updateTweetRequest.getDescription());
		updateTweet.set("lastUpdatedTime", new Date());

		try {
			mongoTemplate.updateFirst(query, updateTweet, Tweet.class);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean deleteTweet(String tweetId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(tweetId));

		try {
			mongoTemplate.remove(query, Tweet.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean likeTweet(String tweetId, String loginId) {
		Likes updateLikes = new Likes();
		updateLikes.setLikedBy(loginId);
		updateLikes.setLikedTime(new Date());

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(tweetId));

		Update update = new Update().push("likes", updateLikes);

		try {
			mongoTemplate.upsert(query, update, Tweet.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean replyTweet(ReplyTweetRequest replyTweetRequest) {
		Comments replyComments = new Comments();
		replyComments.setPostedBy(replyTweetRequest.getPostedBy());
		replyComments.setDescription(replyTweetRequest.getDescription());
		replyComments.setPostedTime(new Date());

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(replyTweetRequest.getTweetId()));

		Update update = new Update().push("comments", replyComments);

		try {
			mongoTemplate.upsert(query, update, Tweet.class);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
