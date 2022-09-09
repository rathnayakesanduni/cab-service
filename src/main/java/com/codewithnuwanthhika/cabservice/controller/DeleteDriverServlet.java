package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithnuwanthika.cabservice.service.DriverService;


/**
 * Servlet implementation class DeleteDriverServlet
 */
public class DeleteDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDriverServlet() {
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
		if(action.equals("delete")) {
			deleteDriver(request, response);
			
		}
	}

	private void deleteDriver(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = "";
    	int driverID = Integer.parseInt(request.getParameter("driverID"));
    	 DriverService service = new  DriverService();
    	try {
			service.deleteDriver(driverID);
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
   
    	response.sendRedirect("/cab-service/ViewDriverServlet?action=all");
	}

}
