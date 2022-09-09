package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithnuwanthika.cabservice.model.User;
import com.codewithnuwanthika.cabservice.service.UserService;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
		
		if(action.equals("add")) {
			addUser(request,response);
		}
	}
	
	 private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
		   String message = "";
		   UserService service = new UserService();
		   
		   User user= new User();
		   user.setUserName(request.getParameter("name"));
		   user.setAddress(request.getParameter("address"));
		   user.setContactNo(request.getParameter("contactNo"));
		   
		   user.setUserPassword(request.getParameter("userPassword"));
		   user.setRoleID(Integer.parseInt(request.getParameter("roleID")));
		   try {
			boolean result = service.addUser(user);
			 if(result) {
				message = "This user has been added successfully! User Name:" + user.getUserName();
			 }
			 else {
				 message = "Failed to add the user! User Name:" + user.getUserName();
			 }
		   } catch (ClassNotFoundException | SQLException e) {
			   message = e.getMessage();
		   }
		   
		   request.setAttribute("message", message);	
			RequestDispatcher rd = request.getRequestDispatcher("add-user.jsp");
			rd.forward(request, response);
		   
	   }

}
