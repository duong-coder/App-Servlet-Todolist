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

@WebServlet(urlPatterns = {"/deletenote"})
public class ServletDeleteNote extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = JDBCConnection.getConnection();
		String deleteNote = "DELETE FROM notes WHERE IDNote = ?;";
		int idNote = Integer.valueOf(req.getParameter("idnote"));
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteNote);
			preparedStatement.setInt(1, idNote);
			
			int resuilt =  preparedStatement.executeUpdate();
			System.out.println(resuilt);
			resp.sendRedirect("./getnotes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
