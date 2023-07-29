<%@page import="dto.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href=".">
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>



	<h1>Welcome to ToDo</h1>

	<table style="border: 1px solid black;">

		<tr>
			<th>ID</th>
			<th>Task Name</th>
			<th>Task Description</th>
			<th>Task Date</th>
			<th>Complete Before</th>
			<th>Status</th>
			<th>Change Status</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		List<Task> list = (List<Task>) request.getAttribute("list");
		for (Task task : list) {
		%>
		<tr>
			<td><%=task.getId()%></td>
			<td><%=task.getTask_Name()%></td>
			<td><%=task.getTask_Description()%></td>
			<td><%=task.getTask_date()%></td>
			<td><%=task.getComplete_before()%></td>
			<td><%=task.isStatus()%></td>
			<td><button>change</button></td>
			<td><button>delete</button></td>
			<td><button>update</button></td>
		</tr>
		<%
		}
		%>



	</table>
	<br>
	<br>
	<a href="task.html"><button style="margin-left: 20px">add
			task</button></a>
	<button style="margin-left: 500px">delete</button>
	<a href="login.html"><button type="button">logout</button></a>


</body>
</html>