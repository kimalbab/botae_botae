package com.br.model.vo;

public class Users {
	
	
	private int userNo;
	private String userId;
	private String userPwd;
	
	public Users() {
		
	}

	public Users(int userNo, String userId, String userPwd) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "Users [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + "]";
	}
	
	

}
