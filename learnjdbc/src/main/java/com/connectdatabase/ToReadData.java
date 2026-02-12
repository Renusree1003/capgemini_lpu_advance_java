package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ToReadData {
	public static void main(String[] args) {
		
	
	String url = "jdbc:postgresql://localhost:5432/school";
	String un="postgres";
	String pwd="root";
	//to read the data
	Scanner sc = new Scanner(System.in);
	
	try {
		Class.forName("org.postgresql.Driver");
		Connection connect=DriverManager.getConnection(url,un,pwd);
		String sql="insert into student values(?,?,?,?)";
		PreparedStatement pstm = connect.prepareStatement(sql);
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		pstm.setInt(1, id);
		//pstm.setInt(1, 110);
		System.out.println("Enter name: ");
		String name = sc.next();
		pstm.setString(2, name);
		//pstm.setString(2, "abhi");
		System.out.println("Enter email: ");
		String email=sc.next();
		pstm.setString(3, email);
		//pstm.setString(3, "abhi@gmail.com");
		System.out.println("Enter gender: ");
		String gender = sc.next();
		pstm.setString(4, gender);
		//pstm.setString(4, "female");
		pstm.execute();
		pstm.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
	}

}
