package com.todolist.dao;

import java.sql.SQLException;

import com.todolist.model.User;

public interface UserDAO {
	void updateUser(User user);
	void deleteUser(User user);
	void insertUser(User user) throws SQLException;
}
