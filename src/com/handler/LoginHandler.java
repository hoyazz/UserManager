package com.handler;

import com.bean.LoginBean;
import com.dao.Dao;

// Used to handle login
public class LoginHandler {
	
	public String validate(LoginBean lb) {
		Dao dao = new Dao();
		boolean exists = false;
		exists = dao.userExists(lb);
			
		if(exists) {
			return "success";
		} else {
			return "error";
		}
	}
}
