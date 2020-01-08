package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Question;
import com.revature.models.Quiz;
import com.revature.util.ConnectionUtil;
import com.revature.util.Logging;

public class QuizDaoImpl implements QuizDao {
	private static final String QUIZ_INSERT = "INSERT INTO quizzes(q_id, subject, description) "
			+ " VALUES(quiz_id_seq.nextval, ?, ?)";
	private static QuizDao instance = new QuizDaoImpl();

	private QuizDaoImpl() {
	}

	public static QuizDao getInstance() {
		return instance;
	}

	@Override
	public Quiz findQuiz(int quizId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createQuiz(String topic, String description) {
		try (Connection c = ConnectionUtil.getConnection()) {

			PreparedStatement stmt = c.prepareCall(QUIZ_INSERT);
			stmt.setString(1, topic);
			stmt.setString(2, description);
			int result = stmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			Logging.logSQLException(e);
		}
		return 0;
	}

	@Override
	public void addQuestions(List<Question> questions) {
		// TODO Auto-generated method stub

	}
}
