package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.JDBCConnection;

@WebServlet(urlPatterns = {"/dangkytaikhoan"})
public class ServletSignUp extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		
		Connection connection = JDBCConnection.getConnection();
		String insertUser = "INSERT INTO usernote(UserName, UserPass, FullName, Gender, SDT, Email) values(?, ?, ?, ?, ?, ?);";
		String userName = req.getParameter("username");
		String pass = req.getParameter("pass");
		String fullName = req.getParameter("fullname");
		String genderStr = req.getParameter("gender");
		String gender;
		if(genderStr.equalsIgnoreCase("true")) {
			gender = "Nam";
		} else {
			gender = "Nu";
		}
		String sdt = req.getParameter("sdt");
		String email = req.getParameter("email");
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertUser);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, pass);
			preparedStatement.setString(3, fullName);
			preparedStatement.setString(4, gender);
			preparedStatement.setString(5, sdt);
			preparedStatement.setString(6, email);
			
			int resuilt =  preparedStatement.executeUpdate();
			System.out.println(resuilt);
			resp.sendRedirect("./getdangnhap");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
}
