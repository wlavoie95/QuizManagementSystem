package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			Logging.logClassNotFoundException(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = SQLInfo.getURL();
		String username = SQLInfo.getUsername();
		String password = SQLInfo.getPassword();
		return DriverManager.getConnection(url, username, password);
	}
}
