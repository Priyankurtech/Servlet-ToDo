<%@page import="dto.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>

<form method="post">
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
			<td><a href="changestatus?id=<%=task.getId()%>"><button>change</button></a></td>
			<td><a href="deleterow?id=<%=task.getId()%>"><button>delete</button></a></td>
			<td><a href="edittask?id=<%=task.getId()%>"><button>Update</button></a></td>
		</tr>
		<%
		}
		%>



	</table>
	

</form>
<br>
	<br>
	<a href="addtask"><button style="margin-left: 20px" type="button">add task</button></a>
	<button style="margin-left: 500px">delete</button>
	<a href="logout"><button type="button">logout</button></a>

	

</body>
</html>