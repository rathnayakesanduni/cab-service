package com.codewithnuwanthika.cabservice.service;

import java.sql.SQLException;

import com.codewithnuwanthika.cabservice.dao.FeedbackDao;
import com.codewithnuwanthika.cabservice.model.Feedback;


public class FeedbackService {
public  boolean addFeedback(Feedback feedback) throws ClassNotFoundException, SQLException {
		
		return FeedbackDao.addFeedback(feedback);
	}
}
