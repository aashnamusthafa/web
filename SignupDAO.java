package com.deloitte.limetray.dao;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.deloitte.limetray.model.Signup;



public class SignupDAO {
	
	public static Connection connectionToDB() {
		Connection connection=null;
		//Step 1 Register the driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
		    return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public static void addSignup(Signup users)
	{
		try {
			Connection con=connectionToDB();
			PreparedStatement stmt=con.prepareStatement("insert into signup values(?,?,?,?,?)");
			stmt.setString(1, users.getUserId());
			stmt.setString(2, users.getUserName());
			stmt.setString(3, users.getPassword());
			stmt.setString(4, users.getEmailId());
			stmt.setInt(5, users.getPhone() );
			int affectedRows=stmt.executeUpdate();
			System.out.println("Affected Rows="+affectedRows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    public static ArrayList<Signup> displayUsers()
    {
    	Connection con=connectionToDB();
    	ArrayList<Signup> userlist=new ArrayList<Signup>();
    	
		try {
			PreparedStatement stmt = con.prepareStatement("select * from signup");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				Signup users=new Signup();
				users.setUserId(rs.getString(1));
				users.setUserName(rs.getString(2));
				users.setPassword(rs.getString(3));
				users.setEmailId(rs.getString(4));
				users.setPhone(rs.getInt(5));
				userlist.add(users);
				
				
			}
			return userlist;
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
    	
		
    	
    	
    }
    public static boolean checkLogin(String uname,String pass)
    {
    	boolean flag=false;
    	Connection con=connectionToDB();
    	try {
			PreparedStatement stmt=con.prepareStatement("select * from signup where uname=? and password=?");
			stmt.setString(1, uname);
			stmt.setString(2, pass);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				
				
					flag=true;
				
			}
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
	
	
	
	

}
