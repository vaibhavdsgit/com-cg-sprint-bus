package com.cg.sprint.bus.service;

import java.util.List;

import com.cg.sprint.bus.model.FeedBack;

public interface IFeedBackService {

	public FeedBack addFeedBack(FeedBack feedBack);
	public FeedBack updateFeedBack(FeedBack feedBack);
	public FeedBack deleteFeedBack(int feedBackId);
	public FeedBack viewFeedBack(int feedBackId);
	public List<FeedBack> viewAllFeedBack();
}
