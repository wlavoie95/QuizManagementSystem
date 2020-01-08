package com.revature.daos;

import java.util.List;

import com.revature.models.Question;
import com.revature.models.Quiz;

public interface QuizDao {

	Quiz findQuiz(int quizId);

	int createQuiz(String topic, String description);

	void addQuestions(List<Question> questions); // Allows for any number of questions to be added to a quiz

}
