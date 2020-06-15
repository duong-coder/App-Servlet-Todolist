package com.todolist.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todolist.dao.JDBCConnection;
import com.todolist.dao.TodolistDAO;
import com.todolist.model.Todolist;
import com.todolist.model.User;
import com.todolist.model.UserSignin;

public class TodolistServiceImpl implements TodolistDAO{
	private Connection connection = JDBCConnection.getConnection();
	private PreparedStatement prepare;

	@Override
	public void insertTodo(Todolist todolist) throws SQLException {
		String insertTodoSQL = "insert into listnote (Username, Title, NgayGhi, Content) values (?, ?, ?, ?)";
		prepare = connection.prepareStatement(insertTodoSQL);
		
		prepare.setString(1, todolist.getUsername());
		prepare.setString(2, todolist.getTitle());
		prepare.setString(3, todolist.getDate());
		prepare.setString(4, todolist.getContent());
		
		prepare.executeUpdate();
	}
	@Override
	public List<Todolist> getAllListTodo(User userSignin) {
		String selectAllTodoSQL = "select * from listnote where Username = ?";
		List<Todolist> todolists = new ArrayList<Todolist>();
		try {
			prepare = connection.prepareStatement(selectAllTodoSQL);
			prepare.setString(1, userSignin.getUsername());
			
			ResultSet resultSet =  prepare.executeQuery();
			while(resultSet.next()) {
				int index = resultSet.getInt("Id");
				String username = resultSet.getString("Username");
				String title = resultSet.getString("Title");
				String date = resultSet.getString("NgayGhi");
				String content = resultSet.getString("Content");
				
				Todolist todolist = new Todolist(index, username, title, date, content);
				todolists.add(todolist);
			}
			
			return todolists;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateTodo(Todolist todolist) throws SQLException {
		String updateTodoSQL = "update listnote set Title = ?, NgayGhi = ?, Content = ? where Id = ?";
		prepare = connection.prepareStatement(updateTodoSQL);
		
		prepare.setString(1, todolist.getTitle());
		prepare.setString(2, todolist.getDate());
		prepare.setString(3, todolist.getContent());
		prepare.setInt(4, todolist.getIndex());
		
		boolean resuilt = false;
		resuilt =  prepare.executeUpdate() > 0;
		return resuilt;
	}

	@Override
	public boolean deleteTodo(int index) throws SQLException {
		String deleteTodoSQL = "delete from listnote where Id = ?";
		prepare = connection.prepareStatement(deleteTodoSQL);
		prepare.setInt(1, index);
		boolean resuilt = false;
		resuilt = prepare.executeUpdate() > 0;
		return false;
	}

	@Override
	public Todolist getTodo(int index) throws SQLException {
		String selectTodoSQL = "select * from listnote where Id = ?";
		Todolist todolist = null;
		try {
			prepare = connection.prepareStatement(selectTodoSQL);
			prepare.setInt(1, index);
			
			ResultSet resultSet =  prepare.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("Id");
				String username = resultSet.getString("Username");
				String title = resultSet.getString("Title");
				String date = resultSet.getString("NgayGhi");
				String content = resultSet.getString("Content");
				System.out.println(content);
				todolist = new Todolist(id, username, title, date, content);
			}
			
			return todolist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
