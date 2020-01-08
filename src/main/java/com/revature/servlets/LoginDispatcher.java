package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.LoginForm;
import com.revature.models.User;
import com.revature.util.Logging;
import com.revature.util.JsonReader;

public class LoginDispatcher implements Dispatcher {
	private User loggedInUser = null;
	private UserDao userDao = UserDaoImpl.getInstance();

	@Override
	public boolean isSupported(HttpServletRequest req) {

		return isLoginRequest(req);
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			LoginForm credentials = (LoginForm) JsonReader.read(req.getInputStream(), LoginForm.class);
			loggedInUser = userDao.login(credentials.getUsername(), credentials.getPassword());
			
			if (loggedInUser == null) {
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			} else {
				resp.setStatus(HttpServletResponse.SC_OK);
				resp.setContentType(JsonReader.CONTENT_TYPE);
				Cookie cookie = new Cookie("currentUser", loggedInUser.getUsername());
				cookie.setPath("/QMS/api");
				resp.getOutputStream().write(JsonReader.write(loggedInUser));
				return;
			}
		} catch (IOException e) {
			Logging.logJsonUnmarshalException(e, LoginForm.class);
		}

	}

	private boolean isLoginRequest(HttpServletRequest req) {
		return req.getMethod().equals("POST") && req.getRequestURI().equals("/QMS/api/login");
	}

}