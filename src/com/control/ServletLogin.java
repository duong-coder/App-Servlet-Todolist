package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.JDBCConnection;
import com.database.User;

@WebServlet(urlPatterns = {"/dangnhap"})
public class ServletLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		Connection connection = JDBCConnection.getConnection();
		String getUser = "SELECT * FROM usernote WHERE UserName = ? and UserPass = ?;";
		String userName = req.getParameter("username");
		String userpass = req.getParameter("pass");
		if(userName == "" || userpass == "") {
			resp.sendRedirect("./getdangnhap");
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(getUser);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, userpass);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setUserName(resultSet.getString("UserName"));
				user.setUserPass(resultSet.getString("UserPass"));
				user.setFullName(resultSet.getString("Fullname"));
				user.setGender(resultSet.getString("Gender"));
				user.setSDT(resultSet.getString("SDT"));
				user.setEmail(resultSet.getString("Email"));
				RequestDispatcher dispatcher = req.getRequestDispatcher("./");
				req.setAttribute("user", user);
				getServletContext().setAttribute("name", user);
				dispatcher.forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
