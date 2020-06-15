package com.todolist.controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todolist.model.User;
import com.todolist.service.UserService;

@WebServlet(urlPatterns = {"/signup"})
public class UserSignupController extends HttpServlet{
	private UserService userService = new UserService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String genderStr = req.getParameter("gender");
		boolean gender = true;
		if(genderStr.equalsIgnoreCase("male")) {
			gender = false;
		}
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		User user = new User(username, password, fullname, gender, email, phone);
		try {
			userService.signupUser(user);
			resp.sendRedirect("./home");
		} catch (SQLException e) {
			resp.sendRedirect("./signup");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("./signup.jsp");
	}
}
