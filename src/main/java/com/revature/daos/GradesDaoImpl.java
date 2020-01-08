package com.revature.daos;

import java.util.List;

import com.revature.models.Grade;

public class GradesDaoImpl implements GradesDao{
	private static GradesDao instance = new GradesDaoImpl();
	// Needs to get Quiz Name and Quiz Grade -> join grades table and quiz table (only show columns Subject and Score)
	private static final String GRADES_QUERY = "SELECT q.subject, g.score FROM grades g "
			+ "INNER JOIN quizzes q USING (q_id) "
			+ "WHERE u_id = ?"; 
	
	private GradesDaoImpl() {}

	GradesDao getInstance() {
		return instance;
	}

	@Override
	public List<Grade> getGrades(int userId) {
		return null;
	}
		
}
