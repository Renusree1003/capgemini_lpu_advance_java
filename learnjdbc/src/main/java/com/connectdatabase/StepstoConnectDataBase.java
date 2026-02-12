package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StepstoConnectDataBase {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/school";
		String un="postgres";
		String pwd="root";
		//Load the driver class
		try {
		Class.forName("org.postgresql.Driver");
		//to establish connection
		System.out.println("Class loaded");
		
			Connection connect=DriverManager.getConnection(url,un,pwd);
			System.out.println("connection created");
			String sql="insert into student values(109,'neha','neha@gmail.com','female'),(2,'renusree','renu@gmail.com','female')";
			//create stmt
			Statement stmt = connect.createStatement();
			//execute query
			stmt.execute(sql);
			connect.close();
			System.out.println("Data inserted");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		 
		}catch(SQLException e) {
			e.printStackTrace();
		}
}
}


