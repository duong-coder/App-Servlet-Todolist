package com.todolist.controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todolist.model.Todolist;
import com.todolist.model.User;
import com.todolist.model.UserSignin;
import com.todolist.service.TodolistServiceImpl;

@WebServlet(urlPatterns = {"/todolists", "/insert", "/edit", "/delete"})
public class UserTodolistController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		System.out.println(path);
		switch (path) {
		case "/edit": {
			getEditTodo(req, resp);
			break;
		}
		case "/delete": {
			deleteTodo(req, resp);
			break;
		}
		default:{
			TodolistServiceImpl todolistServiceImpl = new TodolistServiceImpl();
			User userSignin = (User) getServletContext().getAttribute("user");
			ArrayList<Todolist> todolists = (ArrayList<Todolist>) todolistServiceImpl.getAllListTodo(userSignin);
			getServletContext().setAttribute("todolists", todolists);
			
			resp.sendRedirect("./ghichu.jsp");
		}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		System.out.println(path);
		switch (path) {
		case "/insert": {
			insertTodo(req, resp);
			break;
		}
		case "/edit": {
			editTodo(req, resp);
			break;
		}
		}
	}
	
	private void insertTodo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = ((User) getServletContext().getAttribute("user")).getUsername();
		String title = req.getParameter("title");
		String date = req.getParameter("date");
		String content = req.getParameter("content");
		
		Todolist todolist = new Todolist(username, title, date, content);
		TodolistServiceImpl todolistServiceImpl = new TodolistServiceImpl();
		try {
			todolistServiceImpl.insertTodo(todolist);
			resp.sendRedirect("./todolists");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getEditTodo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int indexTodo = Integer.parseInt(req.getParameter("indexTodo"));
		System.out.println(indexTodo);
		TodolistServiceImpl todolistServiceImpl = new TodolistServiceImpl();
		try {
			Todolist todolist = todolistServiceImpl.getTodo(indexTodo);
			getServletContext().setAttribute("todoEdit", todolist);
			getServletContext().setAttribute("action", "./edit");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		resp.sendRedirect("./todolists");
	}
	
	private void editTodo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Todolist todolistEdit = (Todolist) getServletContext().getAttribute("todoEdit");
		int index = todolistEdit.getIndex();
		String username = ((User) getServletContext().getAttribute("user")).getUsername();
		String title = req.getParameter("title");
		String date = req.getParameter("date");
		String content = req.getParameter("content");
		
		Todolist todolist = new Todolist(index, username, title, date, content);
		getServletContext().setAttribute("todoEdit", null);
		TodolistServiceImpl todolistServiceImpl = new TodolistServiceImpl();
		try {
			todolistServiceImpl.updateTodo(todolist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().setAttribute("action", "./insert");
		resp.sendRedirect("./todolists");
	}
	
	private void deleteTodo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int indexTodo = Integer.parseInt(req.getParameter("indexTodo"));
		TodolistServiceImpl todolistServiceImpl = new TodolistServiceImpl();
		try {
			boolean resuilt =  todolistServiceImpl.deleteTodo(indexTodo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServletContext().setAttribute("action", "./insert");
		resp.sendRedirect("./todolists");
	}
}
