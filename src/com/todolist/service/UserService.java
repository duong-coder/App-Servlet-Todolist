package com.todolist.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todolist.dao.JDBCConnection;
import com.todolist.dao.UserDAO;
import com.todolist.model.User;
import com.todolist.model.UserSignin;

public class UserService implements UserDAO{
	private Connection connection = JDBCConnection.getConnection();
	private PreparedStatement prepare;
	@Override
	public void signupUser(User user) throws SQLException {
		String sqlInsert = "INSERT INTO todolist.user(Username, Password, FullName, Gender, Email, Phone ) VALUES(?, ?, ?, ?, ?, ?)";
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
	@Override
	public User getSigninUser(UserSignin userSignin) throws SQLException {
		String signinSQL = "Select * from user where Username = ? and Password = ?";
		prepare = connection.prepareStatement(signinSQL);
		
		prepare.setString(1, userSignin.getUsername());
		prepare.setString(2, userSignin.getPassword());
		
		ResultSet rowEfec = prepare.executeQuery();
		User user = new User();
		while(rowEfec.next()) {
			user.setUsername(rowEfec.getString("Username"));
			user.setPassword(rowEfec.getString("Password"));
			user.setFullname(rowEfec.getString("FullName"));
			user.setGender(rowEfec.getBoolean("Gender"));
			user.setEmail(rowEfec.getString("Email"));
			user.setPhone(rowEfec.getString("Phone"));
		}
		System.out.println("Row Efect: " + rowEfec);
		return user;
		
	}

	

}
