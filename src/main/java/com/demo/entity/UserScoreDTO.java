package com.demo.entity;


public class UserScoreDTO {

	private Integer userId;

	private String userName;

	private Double score;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "UserScoreDTO [userId=" + userId + ", userName=" + userName
				+ ", score=" + score + "]";
	}

	public UserScoreDTO() {
	}

	public UserScoreDTO(Integer userId, String userName, Double score) {
		this.userId = userId;
		this.userName = userName;
		this.score = score;
	}
	
	public static enum STATUS {
		CREATE, SUCC, FAIL
	}

}
