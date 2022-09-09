package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codewithnuwanthika.cabservice.dao.LoginDao;
import com.codewithnuwanthika.cabservice.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User();

		user.setUserName(userName);
		user.setUserPassword(password);

		LoginDao loginDao = new LoginDao();

		try
		{
			User userValidate = LoginDao.authenticateUser(user);
            
			if(userValidate.getRoleID()==1)
			{
				System.out.println("User's Home");

				HttpSession session = request.getSession();
				session.setAttribute("User", userName);
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("User.jsp").forward(request, response);
			}
			else if(userValidate.getRoleID()==2)
			{
				System.out.println("Admin's Home");

				HttpSession session = request.getSession(); //Creating a session
				session.setAttribute("Admin", userName); //setting session attribute
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("Admin.jsp").forward(request, response);
			}
			
			
			else if(userValidate.getRoleID()==3)
			{
				System.out.println("Driver's Home");

				HttpSession session = request.getSession();
				session.setAttribute("Driver", userName);
				request.setAttribute("userName", userName);

				request.getRequestDispatcher("Driver.jsp").forward(request, response);
			}
			
			
			else
			{
				request.setAttribute("status", "failed");

				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			request.setAttribute("status", "error");
		}
		
	} //End of doPost()
	

}
