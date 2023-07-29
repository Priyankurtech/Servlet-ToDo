package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.Task;
import dto.User;



@WebServlet("/addtask")
public class AddingTask extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String taskname=req.getParameter("taskname");
	String taskdescription=req.getParameter("taskdescription");
	int numberofdays=Integer.parseInt(req.getParameter("numberofdays"));
	LocalDate date=LocalDate.now();
	
//	Task task=dao.fetchbyname(taskname);
//	
//	if (task==null) {
		Task task=new Task();
		
		task.setTask_Name(taskname);
		task.setTask_date(date);
		task.setTask_Description(taskdescription);
		task.setComplete_before(date.plusDays(numberofdays));
		task.setStatus(false);
		UserDao dao=new UserDao();
		dao.save(task);
		resp.getWriter().print("<h1>task added sucessfully</h1>");
		List<Task> list= dao.fetchAlltask();
		req.setAttribute("list", list);

		req.getRequestDispatcher("home.jsp").include(req, resp);
	   
	
	}
	
	
}

