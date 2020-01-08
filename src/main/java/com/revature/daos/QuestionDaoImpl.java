package com.revature.daos;

import java.util.List;

import com.revature.models.Question;

public class QuestionDaoImpl implements QuestionDao {

	private static QuestionDao instance = new QuestionDaoImpl();

	private QuestionDaoImpl() {
	}

	public QuestionDao getInstance() {
		return instance;
	}

	@Override
	public void createQuestion(String question, String[] answers) {
		
	}

	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question findById() {
		// TODO Auto-generated method stub
		return null;
	}

}
