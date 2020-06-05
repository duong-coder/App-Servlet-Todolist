package com.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.JDBCConnection;
import com.database.User;

@WebServlet(urlPatterns = {"/addnotes"})
public class ServletNotes extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = JDBCConnection.getConnection();
		String insertNote = "INSERT INTO notes(UserName, Notes) VALUES(?, ?)";

		try {
			User user = (User) getServletContext().getAttribute("name");
			String contentNote = req.getParameter("note");
			String userName = user.getUserName();
			PreparedStatement preparedStatement = connection.prepareStatement(insertNote);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, contentNote);
			
			int resuilt = preparedStatement.executeUpdate();
			System.out.println(resuilt);
			
			resp.sendRedirect("./getnotes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
