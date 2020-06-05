package com.todolist.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.todolist.dao.JDBCConnection;
import com.todolist.dao.UserDAO;
import com.todolist.model.User;

public class UserService implements UserDAO{
	private Connection connection = JDBCConnection.getConnection();
	private PreparedStatement prepare;
	@Override
	public void insertUser(User user) throws SQLException {
		String sqlInsert = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)";
			prepare = connection.prepareStatement(sqlInsert);
			prepare.setString(1, user.getUsername());
			prepare.setString(2, user.getPassword());
			prepare.setString(3, user.getFullname());
			prepare.setBoolean(4, user.isGender());
			prepare.setString(5, user.getEmail());
			prepare.setString(6, user.getPhone());
			
			int rowEfec =  prepare.executeUpdate();
			System.out.println("Row Efect: " + rowEfec);
	}
	@Override
	public void updateUser(User user) {
		
	}
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	

}
