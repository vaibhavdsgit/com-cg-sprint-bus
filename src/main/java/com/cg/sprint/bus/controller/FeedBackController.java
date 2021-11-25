package com.cg.sprint.bus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.bus.model.FeedBack;
import com.cg.sprint.bus.service.FeedBackService;

@RestController
public class FeedBackController implements IFeedBackController{
	
	private static final Logger LOG = LoggerFactory.getLogger(FeedBackController.class);
	
	@Autowired
	private FeedBackService feedBackService;

	@Override
	@PostMapping("/addFeedBack")
	public ResponseEntity<FeedBack> addFeedBack(@RequestBody FeedBack feedBack) {
		LOG.info("addFeedback Controller");
		FeedBack f = feedBackService.addFeedBack(feedBack);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Feedback has been added to the dataBase");
		ResponseEntity<FeedBack> response = new ResponseEntity<FeedBack>(f, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@PostMapping("/updateFeedBack")
	public ResponseEntity<FeedBack> updateFeedBack(@RequestBody FeedBack feedBack) {
		LOG.info("updateFeedback Controller");
		FeedBack f = feedBackService.updateFeedBack(feedBack);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Feedback has been updated to the dataBase");
		ResponseEntity<FeedBack> response = new ResponseEntity<FeedBack>(f, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@PostMapping("/deleteFeedBack/{feedBackId}")
	public ResponseEntity<FeedBack> deleteFeedBack(@PathVariable int feedBackId) {
		LOG.info("deleteFeedback Controller");
		FeedBack f = feedBackService.deleteFeedBack(feedBackId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Feedback has been deleted from the dataBase");
		ResponseEntity<FeedBack> response = new ResponseEntity<FeedBack>(f, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@PostMapping("/viewFeedBack/{feedBackId}")
	public ResponseEntity<FeedBack> viewFeedBack(@PathVariable int feedBackId) {
		LOG.info("updateFeedback Controller");
		FeedBack f = feedBackService.viewFeedBack(feedBackId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Feedback has been updated to the dataBase");
		ResponseEntity<FeedBack> response = new ResponseEntity<FeedBack>(f, headers, HttpStatus.OK);
		return response;
	}

	@Override
	public List<FeedBack> viewAllFeedBack() {
		LOG.info("updateFeedback Controller");
		return feedBackService.viewAllFeedBack();
	}

}
