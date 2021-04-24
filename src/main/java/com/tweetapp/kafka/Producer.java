package com.tweetapp.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.tweetapp.util.TweetConstants;

@Service
public class Producer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void publishToTopic(String notification) {
		this.kafkaTemplate.send(TweetConstants.KAFKA_NOTIFICATIONS, notification);
	}

}
