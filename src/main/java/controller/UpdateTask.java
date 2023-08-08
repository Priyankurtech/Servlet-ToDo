package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.Task;
import dto.User;

@WebServlet("/updatetask")
public class UpdateTask extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	User  user = (User) req.getSession().getAttribute("user1");
		if (user == null) {
			resp.getWriter().print("<h1>Invalid Email</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			int days=Integer.parseInt(req.getParameter("numberofdays"));
			Task task=new Task();
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("taskname");
			String description=req.getParameter("taskdescription");
		  
			task.setId(id);
			task.setTask_Name(name);
			task.setTask_Description(description);
			task.setTask_date(LocalDate.now());
			task.setComplete_before(LocalDate.now().plusDays(days));
			
			UserDao dao=new UserDao();
			dao.update(task);
			User user2=dao.fetchByEmail(user.getMail());
			req.getSession().setAttribute("user1", user2);
			req.getSession().removeAttribute("user1");
			resp.getWriter().print("<h1>update is done</h1>");
			req.setAttribute("list",user2.getTasks());
			req.getRequestDispatcher("home.jsp").include(req, resp);
		}	
}
}
