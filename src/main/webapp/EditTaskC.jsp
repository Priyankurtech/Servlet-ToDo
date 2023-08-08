<%@page import="java.time.Period"%>
<%@page import="dto.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Task task=(Task)request.getAttribute("task"); %>
    <form  action="updatetask" method="post">
    <input type="text" name="id" value="<%=task.getId()%>" hidden="hidden">
		<fieldset>
			<table>
			<tr>
				<td>Task Name</td>
				<td><input type="text" value="<%=task.getTask_Name() %>" name="taskname" required="required"></td>
			</tr>
				<tr>
				<td>Task Description</td>
				<td><input type="text" value="<%=task.getTask_Description()%>" name="taskdescription" required="required"></td>
			</tr>
			<tr>
				<td>Number of days needed</td>
				<td><input type="number" value="<%=Period.between(task.getTask_date(),task.getComplete_before()).getDays()%>" name="numberofdays" required="required"></td>
			</tr>
			</table>
			<br>
			
			<a href="addtask"><button type="submit">Update</button></a>
			<a href="backtohome"><button style="margin-left: 200px" type="button">cancel</button></a>
			
		</fieldset>
	</form>
</body>
</html>