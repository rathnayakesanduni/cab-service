package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithnuwanthika.cabservice.service.VehicaleService;

/**
 * Servlet implementation class DeletVehicleServlet
 */
public class DeletVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletVehicleServlet() {
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
			deleteVehicale(request, response);
			
		}
	}

	private void deleteVehicale(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = "";
    	int vehicleID = Integer.parseInt(request.getParameter("vehicleID"));
    	 VehicaleService service = new  VehicaleService();
    	try {
			service.deleteVehicale(vehicleID);
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
   
    	response.sendRedirect("/cab-service/ViewVehicaleServlet?action=all");
		
	}

}
