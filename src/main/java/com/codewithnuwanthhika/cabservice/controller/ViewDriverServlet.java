package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithnuwanthika.cabservice.model.Driver;
import com.codewithnuwanthika.cabservice.service.DriverService;


/**
 * Servlet implementation class ViewDriverServlet
 */
public class ViewDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDriverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
			
			if(action.equals("all")) {
				getAllDriver(request,response);
			}
			else {
				getSpecificDriver(request,response);
			}
	}

	private void getSpecificDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String message = "";
		  DriverService service = new  DriverService();
		   int driverID= Integer.parseInt(request.getParameter("driverID"));
		   
		   Driver driver= new Driver();
		   try {
			   driver = service.getTheDriverBydriverID(driverID);
			    if(driver.getDriverName().isEmpty() ) {
			    	message = "There is no any driver under driver Id:" +driverID;
			    }
		   } catch (ClassNotFoundException | SQLException e) {
			   message = e.getMessage();
		   }
		   
		    request.setAttribute("message", message);
		    request.setAttribute("driver", driver);
			RequestDispatcher rd = request.getRequestDispatcher("update-Driver.jsp");
			rd.forward(request, response);
		
	}

	private void getAllDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message ="";
		DriverService service = new  DriverService();
		try {
			List<Driver> drivers = service.getAllDriver();
			
			if(drivers.isEmpty()){
				message = "There is no any driver to show";
			}
			
			request.setAttribute("driverList", drivers);
		    
		} catch (ClassNotFoundException | SQLException e) {
			message =e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("view-driver.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
