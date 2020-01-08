package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.QuizDao;
import com.revature.daos.QuizDaoImpl;
import com.revature.models.QuizForm;
import com.revature.util.JsonReader;
import com.revature.util.Logging;

public class QuizDispatcher implements Dispatcher {

	private QuizDao quizDao = QuizDaoImpl.getInstance();

	@Override
	public boolean isSupported(HttpServletRequest request) {
		return isCreateQuizRequest(request);
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			QuizForm newQuiz = (QuizForm) JsonReader.read(req.getInputStream(), QuizForm.class);
			int success = quizDao.createQuiz(newQuiz.getSubject(), newQuiz.getDescription());
			if (success != 0) {
				resp.setStatus(HttpServletResponse.SC_CREATED);
				resp.setContentType(JsonReader.CONTENT_TYPE);
			} else {
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		} catch (IOException e) {
			Logging.logJsonUnmarshalException(e, QuizForm.class);
		}
	}

	private boolean isCreateQuizRequest(HttpServletRequest req) {
		return req.getMethod().equals("POST") && req.getRequestURI().equals("/QMS/api/quiz");
	}
}
