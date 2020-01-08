package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {

	User login(String username, String password);

	List<User> findAllNonManagers();
	
	User findUserById(int userId);
	
	User findUserByUsername(String username);

}
