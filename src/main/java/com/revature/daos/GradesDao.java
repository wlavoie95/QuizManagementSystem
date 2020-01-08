package com.revature.daos;

import java.util.List;

import com.revature.models.Grade;

public interface GradesDao {

	List<Grade> getGrades(int userId); // Returns a list of all of a Users grades for quizzes assigned to them
								   // If a grade is null, it will be shown as "Not Yet Completed" on the client
								   // side
}
