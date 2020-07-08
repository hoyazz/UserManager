package com.handler;

import com.bean.RegisterBean;
import com.dao.Dao;

public class RegisterHandler {
	public String register(RegisterBean rb) {
		Dao dao = new Dao();
		boolean success = false;
		success = dao.registerUser(rb);
		
		if(success) {
			return "success";
		} else {
			return "error";
		}
	}
}
