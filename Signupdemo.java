package com.deloitte.limetray.main;
import java.util.*;

import com.deloitte.limetray.model.Signup;
import com.deloitte.limetray.services.Signupimpl;

public class Signupdemo {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		ArrayList <Signup> list=new ArrayList<Signup>();
		while(true)
		{
			System.out.println("1.SIGN UP");
			System.out.println("2.DISPLAY USERS");
			System.out.println("3.LOGIN");
			System.out.println("4.EXIT");
			System.out.println("Enter choice :");
			String choice=sc.next();
			Signupimpl obj=new Signupimpl();
			switch(Integer.parseInt(choice))
			{
			case 1: System.out.println("Enter USERID :");
					String uid=sc.next();
					System.out.println("Enter Username :");
					String uname=sc.next();
					System.out.println("Enter Password :");
					String pass=sc.next();
					System.out.println("Enter Email id:");
					String email=sc.next();
					System.out.println("Enter Phone number:");
					int no=Integer.parseInt(sc.next());
					Signup users=obj.createSignup(uid,uname,pass,email,no);
					list.add(users);
					break;
				
			case 2:System.out.println("Displaying all users:");
				   list=obj.displayUsers();
				   
				   for(Signup obj1:list)
				   {
					   System.out.println(obj1);
				   }
			case 3:System.out.println("Enter username");
			       String u1=sc.next();
			       System.out.println("Enter password");
			       String u2=sc.next();
			       boolean flag=obj.checkLogin(u1,u2);
			       if(flag==true)
			    	   System.out.println("valid user");
			       else
			    	   	System.out.println("Invalid user");
				
			case 4: System.exit(0);
			}
			
		}
		
		
	}

}
