package com.todolist.dao;

import java.sql.SQLException;

import com.todolist.model.User;
import com.todolist.model.UserSignin;

public interface UserDAO {
	void updateUser(User user);
	void deleteUser(User user);
	void signupUser(User user) throws SQLException;
	User getSigninUser(UserSignin userSignin) throws SQLException;
}
