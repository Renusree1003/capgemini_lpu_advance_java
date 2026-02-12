package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeData {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/school";
		String un="postgres";
		String pwd="root";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");
			Connection connect=DriverManager.getConnection(url,un,pwd);
//			//String sql="insert into employee values(1,'renu','50000'),(2,'driti','10000000')";
//			String sql="insert into employee values(3,'sri','3000')";
//			//String sql="delete from employee where id = 2";
//			Statement stmt = connect.createStatement();
//			//execute query
//			stmt.execute(sql);
//			connect.close();
			
			
				System.out.println("1.insert employee");
				System.out.println("2.delete employee");
				System.out.println("3.update emp sal");
				System.out.println("4.find emp");
				System.out.println("enter choice: ");
				int choice = sc.nextInt();
				if(choice == 1) {
					String sql = "insert into employee values(?,?,?)";
					PreparedStatement pstm = connect.prepareStatement(sql);
					System.out.println("Enter id: ");
					int id = sc.nextInt();
					pstm.setInt(1, id);
					
					System.out.println("Enter name: ");
					String name = sc.next();
					pstm.setString(2, name);
					
					System.out.println("Enter sal: ");
					String sal = sc.next();
					pstm.setString(3, sal);
					
					pstm.execute();
					connect.close();
				}
				else if(choice == 2) {
					String sql = "delete from employee where id = ?";
					PreparedStatement pstm = connect.prepareStatement(sql);
					System.out.println("Enter id to delete: ");
					int id = sc.nextInt();
					pstm.setInt(1, id);
					
					int rows = pstm.executeUpdate();
					System.out.println(rows > 0 ? "Student deleted" : "student not found");
					pstm.close();
				}
				else if(choice == 3) {
					String sql = "update employee set salary = ? where id = ?";
					PreparedStatement pstm = connect.prepareStatement(sql);
					System.out.println("Enter id: ");
					int id = sc.nextInt();
					
					System.out.println("Enter sal: ");
					String salary = sc.next();
					pstm.setString(1, salary);
					pstm.setInt(2, id);
					
					pstm.execute();
					pstm.close();
				}
				else if(choice == 4) {
					String sql = "select * from employee where id = ?";
					PreparedStatement pstm = connect.prepareStatement(sql);
					System.out.println("Enter id: ");
					int id = sc.nextInt();
					pstm.setInt(1, id);
					
					ResultSet rs = pstm.executeQuery();
					if(rs.next()) {
						System.out.println("ID: " + rs.getInt("id"));
						System.out.println("Name: " + rs.getString("name"));
						System.out.println("Salary: " + rs.getString("salary"));
					}
					pstm.close();
				}
			connect.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
