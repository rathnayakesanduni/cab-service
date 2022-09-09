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


public class DriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DriverServlet() {
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
			adddriver(request, response);
			
		}
	}

	private void adddriver(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String message = "";
		Driver driver  = new Driver ();
		DriverService service = new DriverService();
		
		driver.setDriverName(request.getParameter("driverName"));
		driver.setBranchName(request.getParameter("branchName"));
		
		try {
			boolean result = service.adddriver(driver);
			if(result) {
				message = "Details added successfully";
			}
			else {
				message = "There was an error in adding the details";
			}
		} catch (ClassNotFoundException | SQLException e1) {
			message = e1.getMessage();
		}
		
		
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-driver.jsp");
		rd.forward(request, response);
		
	}

}
