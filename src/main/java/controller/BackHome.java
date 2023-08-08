package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;

@WebServlet("/backtohome")
public class BackHome extends HttpServlet{
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
   		req.setAttribute("list",user.getTasks());
   		req.getRequestDispatcher("home.jsp").include(req, resp);
   	}
}
}
