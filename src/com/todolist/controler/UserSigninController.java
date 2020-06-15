package com.todolist.controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todolist.model.User;
import com.todolist.model.UserSignin;
import com.todolist.service.UserService;

@WebServlet(urlPatterns = {"/signin"})
public class UserSigninController extends HttpServlet{
	private UserService userService;
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("signin.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserSignin userSignin = new UserSignin(username, password);
		try {
			User user =  userService.getSigninUser(userSignin);
			if(user == null) {
				resp.sendRedirect("./signup");
			} else {
				getServletContext().setAttribute("user", user);
				resp.sendRedirect("./home");
			}
		} catch (SQLException e) {
			resp.sendRedirect("./signin");
			e.printStackTrace();
		}
		
	}
}
