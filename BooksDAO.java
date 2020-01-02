package com.deloitte.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.deloitte.library.model.Books;

public class BooksDAO {

	public static Connection connectToDB() {
		Connection connection = null;
		// Step 1: Register the driver.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Step 2: Create connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
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

	public static void addBook(Books book) {
	
		// Step 3: Create statement

		try {
			// Statement stmt = connectToDB().createStatement();
			Connection con=connectToDB();
			PreparedStatement stmt = con.prepareStatement("insert into books values(?,?,?,?)");
			stmt.setInt(1, book.getBookId());
			stmt.setString(2, book.getBookName());
			stmt.setString(3, book.getBookAuthor());
			stmt.setDouble(4, book.getBookPrice());
			// Step 4: Execute SQL Query
			int affectedRows = stmt.executeUpdate();
			System.out.println("Affected rows " + affectedRows);
			
			//Step 5:Close Connection
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
