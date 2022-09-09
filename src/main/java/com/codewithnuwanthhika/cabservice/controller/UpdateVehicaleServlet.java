package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithnuwanthika.cabservice.model.Vehicale;
import com.codewithnuwanthika.cabservice.service.VehicaleService;

/**
 * Servlet implementation class UpdateVehicaleServlet
 */
public class UpdateVehicaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicaleServlet() {
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
		if(action.equals("update")) 
		{
			updateVehicale(request,response);
		}
	}

	private void updateVehicale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String message = "";
		   VehicaleService service = new  VehicaleService();
		   
		   Vehicale vehicale= new Vehicale();
		   vehicale.setVehicleID(Integer.parseInt(request.getParameter("vehicleID")));
		   vehicale.setVehicleName(request.getParameter("vehicleName"));
		   vehicale.setVehicaleNumber(request.getParameter("vehicaleNumber"));
		   vehicale.setBranchname(request.getParameter("branchname"));
		   vehicale.setPrice(Integer.parseInt(request.getParameter("price"))); 
		   
		   try {
			 boolean result = service.updateVehicale(vehicale);
		     if(result) {
				message = "The user has been updated successfully!vehicleID:" + vehicale.getVehicleID();
			 }
		     else {
		    	 message = "Failed to update the user! vehicleID:" + vehicale.getVehicleID(); 
		     }
		   } 
		   catch (ClassNotFoundException | SQLException e) {
				message = e.getMessage();
		   }
			   
		   request.setAttribute("message", message);	
		   RequestDispatcher rd = request.getRequestDispatcher("update-vehicale.jsp");
		   rd.forward(request, response);
		
	}

}
