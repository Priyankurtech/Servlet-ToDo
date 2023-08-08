package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.Task;
import dto.User;

@WebServlet("/deleterow")
public class DeleteRow extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
User user=(User) req.getSession().getAttribute("user1");
 		
 		if(user==null)
 		{
 			resp.getWriter().print("<h1>session expired</h1>");
 			req.getRequestDispatcher("login.html").include(req, resp);
 		}
 		else
 		{
 			int id=Integer.parseInt(req.getParameter("id"));
 		    UserDao  dao=new UserDao();
 		    Task task=(Task) dao.fetchTask(id);
 		    user.getTasks().remove(task);
 		    dao.update(user);
 		    	dao.delete(task);
 		    	User user2=dao.fetchByEmail(user.getMail());
 		    	req.getSession().removeAttribute("user1");
 		    	req.getSession().setAttribute("user1", user2);
 		    
 		    
 		    resp.getWriter().print("<h1>Delete is done</h1>");
 		    req.setAttribute("list",user2.getTasks());
 		    req.getRequestDispatcher("home.jsp").include(req, resp);
 		}
    
	}

}
