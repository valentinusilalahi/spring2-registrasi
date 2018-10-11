package com.silalahi.valentinus.app.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silalahi.valentinus.app.dto.DebiturRequest;

@Service
@Transactional
public class KafkaSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

	@Value("${kafka.topic.debitur.request}")
	private String kafkaTopicDebiturRequest;

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void requestCreateDebitur(DebiturRequest request) {
		try {
			String jsonRequest = objectMapper.writeValueAsString(request);
			LOGGER.debug("Create Debitur Request : {}", jsonRequest);
			kafkaTemplate.send(kafkaTopicDebiturRequest, jsonRequest);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.warn(e.getMessage(), e);
		}
	}

}
