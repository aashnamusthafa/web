package com.deloitte.limetray.services;

import java.util.ArrayList;

import com.deloitte.limetray.dao.SignupDAO;
import com.deloitte.limetray.model.Signup;

public class Signupimpl implements Signupinterface {

	@Override
	public Signup createSignup(String uid, String uname, String pass, String email, int no) {
		// TODO Auto-generated method stub
		Signup users=new Signup();
		users.setUserId(uid);
		users.setUserName(uname);
		users.setPassword(pass);
		users.setEmailId(email);
		users.setPhone(no);
		SignupDAO.addSignup(users);
		return users;
	}

	@Override
	public ArrayList<Signup> displayUsers() {
		// TODO Auto-generated method stub
		
		return SignupDAO.displayUsers();
	}

	@Override
	public boolean checkLogin(String uname, String pass) {
		// TODO Auto-generated method stub
		return SignupDAO.checkLogin(uname,pass);
		

	
}
}
