package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithnuwanthika.cabservice.model.Driver;
import com.codewithnuwanthika.cabservice.service.DriverService;


/**
 * Servlet implementation class UpdateDriverServlet
 */
public class UpdateDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDriverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("updateDriver")) 
		{
			updateDriver(request,response);
		}
	}

	private void updateDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String message = "";
		   DriverService service = new  DriverService();
		   
		   Driver driver= new Driver();
		   driver.setDriverID(Integer.parseInt(request.getParameter("driverID")));
		   driver.setDriverName(request.getParameter("driverName"));
		   driver.setBranchName(request.getParameter("branchName"));
		    
		   
		   try {
			 boolean result = service.updateDriver(driver);
		     if(result) {
				message = "The Driver has been updated successfully!DriverID:" + driver.getDriverID();
			 }
		     else {
		    	 message = "Failed to update the driver ! DriverID:" + driver.getDriverID(); 
		     }
		   } 
		   catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
		   }
			   
		   request.setAttribute("message", message);	
		   RequestDispatcher rd = request.getRequestDispatcher("update-Driver.jsp");
		   rd.forward(request, response);
		
	}

}
