package com.todolist.dao;

import java.sql.SQLException;
import java.util.List;

import com.todolist.model.Todolist;
import com.todolist.model.User;
import com.todolist.model.UserSignin;

public interface TodolistDAO {
	void insertTodo(Todolist todolist) throws SQLException;
	Todolist getTodo(int index)throws SQLException;
	List<Todolist> getAllListTodo(User userSignin);
	boolean updateTodo(Todolist todolist) throws SQLException;
	boolean deleteTodo(int index) throws SQLException;
}
