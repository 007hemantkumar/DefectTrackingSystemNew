package com.example.model;

public class LoginResponse {

	private String code;
	private String message;
	private String token;
	public LoginResponse() {
		super();
	}
	public LoginResponse(String code, String message, String token) {
		super();
		this.code = code;
		this.message = message;
		this.token = token;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "LoginResponse [code=" + code + ", message=" + message + ", token=" + token + "]";
	}
	
	
}
