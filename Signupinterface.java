package com.deloitte.limetray.services;

import java.util.ArrayList;

import com.deloitte.limetray.model.Signup;

public interface Signupinterface {
	public Signup createSignup(String uid,String uname,String pass,String email,int no );
	public ArrayList <Signup> displayUsers();
	public boolean checkLogin(String uname,String pass);

}
