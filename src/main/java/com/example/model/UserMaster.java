package com.example.model;

public class UserMaster {

	private long id;
	private String userName;
	private String userRole;
	private String password;

	public UserMaster() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserMaster [id=" + id + ", userName=" + userName + ", userRole=" + userRole + ", password=" + password
				+ "]";
	}

}
