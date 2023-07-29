package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/signup")
public class SignUp extends HttpServlet{
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String name=req.getParameter("name");
	String gen=req.getParameter("gen");
	String mail=req.getParameter("mail");
	long phoneno=Long.parseLong(req.getParameter("phoneno"));
	String address=req.getParameter("address");
	LocalDate dob=LocalDate.parse(req.getParameter("dob"));
	
	String password=req.getParameter("password");
	User user=new User();
	
	
	
	
	
	UserDao dao=new UserDao();
	User user1=dao.fetchByEmail(mail);
	if (user1==null) {
		user=new User();
		user.setName(name);
		user.setPhoneno(phoneno);
		user.setAddress(address);
		user.setDob(dob);
		user.setGen(gen);
		user.setMail(mail);
		user.setPassword(password);
		dao.save(user);
		resp.getWriter().print("<h1>account created sucessfully</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	} else {
		resp.getWriter().print("<h1>email already exist</h1>");
		req.getRequestDispatcher("SignUp.html").include(req, resp);
	}
	
			
	
}
}
