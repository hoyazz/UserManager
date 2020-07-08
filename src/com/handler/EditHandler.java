package com.handler;

import com.bean.RegisterBean;
import com.dao.Dao;

public class EditHandler {
	public String edit(RegisterBean rb) {
		Dao dao = new Dao();
		boolean success = false;
		success = dao.editUser(rb);
		
		if(success) {
			return "success";
		} else {
			return "error";
		}
	}
}
