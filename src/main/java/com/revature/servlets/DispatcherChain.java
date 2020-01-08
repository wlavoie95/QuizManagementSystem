package com.revature.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DispatcherChain implements Dispatcher {

	private final List<Dispatcher> dispatchers;
	private final Logger logger = LogManager.getLogger(getClass());
	private static final DispatcherChain instance = new DispatcherChain();

	/*
	 * Adds a single instance of each dispatcher to the dispatcher chain.
	 */
	private DispatcherChain() {
		this.dispatchers = new ArrayList<>();
		this.dispatchers.add(new LoginDispatcher());
		this.dispatchers.add(new QuizDispatcher());
	}

	/*
	 * Iterates through the list of dispatchers to see if any of them can handle the HTTPServletRequest.
	 */
	@Override
	public boolean isSupported(HttpServletRequest request) {
		for (Dispatcher d : dispatchers) {
			if (d.isSupported(request)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Runs a dispatcher if it supports the request.
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		for (Dispatcher d : dispatchers) {
			if (d.isSupported(request)) {
				d.execute(request, response);
			}
		}
	}

	public static DispatcherChain getInstance() {
		return instance;
	}
}
