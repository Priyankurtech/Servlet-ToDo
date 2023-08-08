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

@WebServlet("/edittask")
public class EditTask extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User  user = (User) req.getSession().getAttribute("user1");
		if (user == null) {
			resp.getWriter().print("<h1>Invalid Email</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			int id = Integer.parseInt(req.getParameter("id"));
			
			UserDao dao = new UserDao();
			Task task = dao.fetchTask(id);
			
			req.setAttribute("task", task);
			req.getRequestDispatcher("EditTaskC.jsp").forward(req, resp);
		}
	}
}
