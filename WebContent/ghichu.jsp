<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.database.JDBCConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.database.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ghi chu</title>
</head>
<body>
	<h1> 
	<%
		
		try{
			User user2 = (User) getServletContext().getAttribute("name");
			out.print(user2.getFullName());
		} catch(Exception e) {
			out.print("Khach");	
		}
	%></h1>
	<h2>Danh sach cac ghi chu: </h2>
	<form action="./addnotes" method="post">
		<label for="note">Note: </label>
		<input type="text" id="note" name="note">
		<input type="submit" value="Luu">
	</form> <br>
	<table>
		<%
			Connection connection = JDBCConnection.getConnection();
			String getNotes = "SELECT * FROM notes WHERE UserName = ?;";
			try{
				User user2 = (User) getServletContext().getAttribute("name");
				String userName = user2.getUserName();
				PreparedStatement preparedStatement = connection.prepareStatement(getNotes);
				preparedStatement.setString(1, userName);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					out.print("<tr> <td>" + resultSet.getString("Notes") + "</td> <td><button onclick='deleteData("+ resultSet.getInt("IDNote") +")'>Xoa</button></tr>");
				}
			} catch(Exception e){
				out.print("Null");
			}
		%>
	</table>
	<a href="./"><button>Quay lai trang chu</button></a>
	
	<script type="text/javascript">
		function deleteData(idNote) {
			//window.open("./deletenote?idnote=" + idNote);
			//respon.setHeader("Location", "./deletenote?idnote=" + idNote);
			var xhttp = new XMLHttpRequest();
			  //xhttp.onreadystatechange = function() {
			    //if (this.readyState == 4 && this.status == 200) {
			      //document.getElementById("demo").innerHTML =
			      //this.responseText;
			    //}
			  //};
			  xhttp.open("GET", "./deletenote?idnote=" + idNote, true);
			  xhttp.send();
		}
	</script>
</body>
</html>