package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;
import com.revature.util.Logging;



public class UserDaoImpl implements UserDao {
	private static UserDao instance = new UserDaoImpl();
	private static final String LOGIN_QUERY = "SELECT u_id, username, u_type FROM user_account WHERE username = ? AND password = ?";

	private UserDaoImpl() {
	}

	private User extractUser(ResultSet rs) throws SQLException {
		return new User(rs.getInt("u_id"), rs.getString("username"), rs.getInt("u_type"));
	}

	public static UserDao getInstance() {
		return instance;
	}

	@Override
	public User login(String username, String password) {
		try (Connection c = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = c.prepareCall(LOGIN_QUERY);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return extractUser(rs);
			}
		} catch (SQLException e) {
			Logging.logSQLException(e);
		}
		return null;
	}

	@Override
	public List<User> findAllNonManagers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
