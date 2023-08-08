package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
		Task task=new Task();
		task.setTask_Name(taskname);
		task.setTask_date(date);
		task.setTask_Description(taskdescription);
		task.setComplete_before(date.plusDays(numberofdays));
		task.setStatus(false);
		User user=(User)req.getSession().getAttribute("user1");
		List<Task> list=user.getTasks();
		if(list==null)
		{
			list=new ArrayList<Task>();
			resp.getWriter().print("<h1>session expired</h1>");
 			req.getRequestDispatcher("login.html").include(req, resp);
		}
			else
			{
				list.add(task);
				user.setTasks(list);
				UserDao dao=new UserDao();
				dao.save(task);
				dao.update(user);
				resp.getWriter().print("<h1>task added sucessfully</h1>");
				req.setAttribute("list", user.getTasks());
    			req.getRequestDispatcher("home.jsp").include(req, resp);
			}
		}
	}


	
	


