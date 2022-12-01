package com.sdetde;

import java.util.ResourceBundle;

public class App {
	
	public int userLogin(String in_user, String in_pwd) {
		ResourceBundle rb=ResourceBundle.getBundle("config");
		String userName=rb.getString("username");
		String passwprd=rb.getString("password");
		if(in_user.equals(userName)&& in_pwd.equals(passwprd)) {
			return 1;
		}
		else
			return 0;
	}

}
