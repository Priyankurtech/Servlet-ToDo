package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/checkaddtasksession")
public class CheckTaskSession extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	if(req.getSession().getAttribute("user1")==null)
    	{
    		resp.getWriter().print("<h1>session expired</h1>");
    		req.getRequestDispatcher("login.html").include(req, resp);
    	}
    	else
    	{
    		req.getRequestDispatcher("task.html").include(req, resp);
    	}
    }
}
