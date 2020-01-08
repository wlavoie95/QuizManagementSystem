package com.revature.daos;

import java.util.List;

import com.revature.models.Question;

public interface QuestionDao {
	
	void createQuestion(String question, String[] answers);

	List<Question> findAll();

	Question findById();
}
