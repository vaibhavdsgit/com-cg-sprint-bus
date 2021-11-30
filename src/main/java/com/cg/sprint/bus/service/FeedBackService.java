package com.cg.sprint.bus.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.bus.model.FeedBack;
import com.cg.sprint.bus.repository.FeedBackRepository;

@Service
public class FeedBackService implements IFeedBackService{
	
	private static final Logger LOG = LoggerFactory.getLogger(FeedBackService.class);
	
	@Autowired
	private FeedBackRepository feedBackRepository;

	@Override
	public FeedBack addFeedBack(FeedBack feedBack) {
		LOG.info("Feedback added");
		return feedBackRepository.save(feedBack);
	}

	@Override
	public FeedBack updateFeedBack(FeedBack feedBack) {
		LOG.info("FeedbackService updateFeedback");
		if(feedBackRepository.existsById(feedBack.getFeedBackId())) {
			LOG.info("Feedback exists and will be updated");
			return feedBackRepository.save(feedBack);
		}
		return null;
	}

	@Override
	public FeedBack deleteFeedBack(int feedBackId) {
		LOG.info("FeedbackService deleteFeedback");
		if(feedBackRepository.existsById(feedBackId)) {
			LOG.info("Deleting Feedback");
			feedBackRepository.deleteById(feedBackId);
			return null;
		}
//		else {
//			LOG.info("User does not exist");
//			throw new UserNotFoundException("Feedback with " + feedBackId + " does not exist");
//		}
		return null;
	}

	@Override
	public FeedBack viewFeedBack(int feedBackId) {
		LOG.info("FeedbackService viewFeedback");
		System.out.println(feedBackRepository.existsById(feedBackId));
		System.out.println(feedBackRepository.getById(feedBackId));
		if(feedBackRepository.existsById(feedBackId)) {
			LOG.info("Viewing Feedback");
			return feedBackRepository.getById(feedBackId);
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<FeedBack> viewAllFeedBack() {
		LOG.info("Viewing all Feedback");
		return feedBackRepository.findAll();
	}

}
