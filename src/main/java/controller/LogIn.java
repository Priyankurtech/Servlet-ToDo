package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.Task;
import dto.User;

@WebServlet("/login")
public class LogIn extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String gmail=req.getParameter("Email");
    	String password=req.getParameter("password");
    	UserDao dao=new UserDao();
    	User user1=dao.fetchByEmail(gmail);
    	
    	if (user1==null) {
    		resp.getWriter().print("<h1>give correct email</h1>");
    		req.getRequestDispatcher("login.html").include(req, resp);
		} 
    	else {
    		if (user1.getPassword().equals(password)) {
    			resp.getWriter().print("<h1>login sucessfull</h1>");
    			List<Task> list=dao.fetchAlltask();
    			req.setAttribute("list", list);
    			req.getRequestDispatcher("home.jsp").include(req, resp);
			}
    		else {
    			resp.getWriter().print("<h1>Invalid password</h1>");
    			req.getRequestDispatcher("login.html").include(req, resp);
			}
			
		} 
    	
    }
}
