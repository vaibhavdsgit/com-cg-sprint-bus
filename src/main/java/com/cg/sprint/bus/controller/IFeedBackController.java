package com.cg.sprint.bus.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.sprint.bus.model.FeedBack;

public interface IFeedBackController {

	public ResponseEntity<FeedBack> addFeedBack(FeedBack route);
	public ResponseEntity<FeedBack> updateFeedBack(FeedBack route);
	public ResponseEntity<FeedBack> deleteFeedBack(int feedBackId);
	public ResponseEntity<FeedBack> viewFeedBack(int FeedBackId);
	public List<FeedBack> viewAllFeedBack();
}
