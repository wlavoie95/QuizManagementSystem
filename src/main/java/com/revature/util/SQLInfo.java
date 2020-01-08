package com.revature.util;

public final class SQLInfo {
	private static final String URL = "jdbc:oracle:thin:@demos-wlavoie.cgo1soxumnwc.us-east-1.rds.amazonaws.com:1521:orcl";
	private static final String USERNAME = "quiz";
	private static final String PASSWORD = "p4ssw0rd";

	private SQLInfo() {
	}

	public static String getURL() {
		return URL;
	}

	public static String getUsername() {
		return USERNAME;
	}

	public static String getPassword() {
		return PASSWORD;
	}

}
