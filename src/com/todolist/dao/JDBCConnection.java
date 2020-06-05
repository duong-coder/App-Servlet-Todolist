package com.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/todolist";
		String user = "root";
		String pass = "1234567890";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		if(JDBCConnection.getConnection() != null) {
			System.out.println("ok");
		}else {
			System.out.println("faild");
		}
	}
}