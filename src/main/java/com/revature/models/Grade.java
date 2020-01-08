package com.revature.models;

public class Grade {
	private String username;
	private String quizTopic;
	private double score;

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade(String username, String quizTopic, double score) {
		super();
		this.username = username;
		this.quizTopic = quizTopic;
		this.score = score;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQuizTopic() {
		return quizTopic;
	}

	public void setQuizTopic(String quizTopic) {
		this.quizTopic = quizTopic;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quizTopic == null) ? 0 : quizTopic.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		if (quizTopic == null) {
			if (other.quizTopic != null)
				return false;
		} else if (!quizTopic.equals(other.quizTopic))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grade [username=" + username + ", quizTopic=" + quizTopic + ", score=" + score + "]";
	}

}
