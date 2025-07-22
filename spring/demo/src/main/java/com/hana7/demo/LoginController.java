package com.hana7.demo;

public class LoginController {
	public String loginForm(){
		String sb = "<form>"
			+ "<input name = 'email'>"
			+ "<button type = 'submit'>Sign in</button>"
			+ "</form>";
		return sb;
	}
}