package com.caps.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caps.model.DAO.LoginI;
import com.caps.model.DAO.LoginM;
import com.caps.model.beans.Students;
import com.caps.model.beans.UserAuth;
import com.caps.model.service.Validation;

@WebServlet("/loginServ")
public class LoginC extends HttpServlet{
	 public int count ;
	 UserAuth u ;
	 HttpSession session;
	 long time;
	 
	
	 Students stud;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("name");
		String passwd = req.getParameter("password");
		System.out.println(userId+passwd);
		boolean login=Validation.login(userId,passwd);
	
		
		long currenttime=new Date().getTime();
		/*s.setPassword(passwd);
		System.out.println(passwd);
		s.setUserid(Integer.parseInt(userId));
		System.out.println(userId);
		
*/
		
	HttpSession s2=req.getSession(false);
	System.out.println(s2);
	
if(login)
{
if(s2==null)
	{
		count=0;
		u=new UserAuth();
		session=req.getSession();
		time=session.getLastAccessedTime();
	}
	System.out.println("attempts = "+u.getAttempts());
	
	System.out.println(currenttime);
	session.setAttribute("userauth", u);

	session.setAttribute("counts", count);
	u.setLogtime(30000);

	if(currenttime-time>u.getLogtime())
	{
		
		u.setLock(false);
		u.setAttempts(0);
		session.invalidate();
	}
	
	/*if(u.getAttempts()>3) 
	{
		u.setLock(true);
	
	}*/
	System.out.println("count = "+count);
	System.out.println("attempts = "+u.getAttempts());

	if(u.getAttempts()<3&&!(u.isLock()))
	{
		System.out.println("inside if "+u.getAttempts());
		stud=new LoginM().main(userId,passwd);//
		if(stud!=null) {
		System.out.println("iam back");
		System.out.println(stud.getFirstname());
		System.out.println(stud.getLastname());
		System.out.println("last me");
		req.setAttribute("stud", stud);
		System.out.println(stud.getFirstname()+stud.getLastname()+stud.getGender()+stud.getUserid()+stud.getType()+stud.getPassword());
		RequestDispatcher dispatcher=req.getRequestDispatcher("Display.jsp");
		System.out.println(req.getParameterValues("stud"));
		dispatcher.forward(req, resp);
		//System.out.println(count);
		}
		else
		{
			u.setAttempts(++count);
			System.out.println("attempts = "+u.getAttempts());
		System.out.println("count = "+count);
			System.out.println("count has value");
			System.out.println("login is failed for"+count);
			RequestDispatcher dispatcher = req.getRequestDispatcher("Invalid.jsp");
			dispatcher.forward(req,resp);
			
			System.out.println("after navi");
		}
		
	}
	else
	{
		PrintWriter out=resp.getWriter();
		out.println("<h1>your account is locked please contact administrator</h1>");
		u.setLock(true);
		System.out.println(u.getAttempts());
		
	}

}}
	

}