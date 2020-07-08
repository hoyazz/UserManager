package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.LoginBean;
import com.bean.RegisterBean;
import com.handler.EditHandler;
import com.handler.LoginHandler;
import com.handler.RegisterHandler;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private static void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LoginBean lb = new LoginBean(request.getParameter("uname"), request.getParameter("pwd"));
		HttpSession session = request.getSession();
		LoginHandler handler = new LoginHandler();
		String result = handler.validate(lb);
		
		if(result.equals("success") ) {
			session.setAttribute("uname", lb.getUname());
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}	
    }
    
    private static void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RegisterBean rb = new RegisterBean(request.getParameter("uname"), request.getParameter("pwd"),
    								request.getParameter("email"), request.getParameter("address"));
		RegisterHandler handler = new RegisterHandler();
		HttpSession session = request.getSession();
		String result = handler.register(rb);
		
		if(result.equals("success") ) {
			response.sendRedirect("success2.jsp");
		} else {
			session.setAttribute("error", "User already exists!");
			response.sendRedirect("register.jsp");
		}	
    }
    
    private static void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
    	RegisterBean rb = new RegisterBean(request.getParameter("uname"), request.getParameter("pwd"),
    								request.getParameter("email"), request.getParameter("address"));
		EditHandler handler = new EditHandler();
		String result = handler.edit(rb);

		if(result.equals("success") ) {
			response.sendRedirect("userdetails.jsp");
		} else {
			session.setAttribute("error", "Error!");
			response.sendRedirect("userdetails.jsp");
		}	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=request.getRequestURL().toString();
		int lastSlash = url.lastIndexOf("/");
		int lastURI = url.lastIndexOf((".do"));
		
		String actualPath=url.substring(lastSlash + 1, lastURI);
		if(actualPath.equals("login")) {
			doLogin(request, response);
		} else if(actualPath.equals("register")) {
			doRegister(request, response);
		} else if(actualPath.equals("edit")) {
			doEdit(request, response);
		} 
		
	}

}
