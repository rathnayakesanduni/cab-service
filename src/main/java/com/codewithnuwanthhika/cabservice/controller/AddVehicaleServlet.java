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
 * Servlet implementation class AddVehicaleServlet
 */
public class AddVehicaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicaleServlet() {
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
		
		if(action.equals("addVehicle")) {
			addVehicale(request,response);
		}
	}

	private void addVehicale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String message = "";
		   VehicaleService service = new  VehicaleService();
		   
		   Vehicale vehicale= new Vehicale();
		   vehicale.setVehicleName(request.getParameter("vehicleName"));
		   vehicale.setVehicaleNumber(request.getParameter("vehicaleNumber"));
		   vehicale.setBranchname(request.getParameter("branchname"));
		   vehicale.setPrice(Integer.parseInt(request.getParameter("price")));
		   
		  
		   try {
			boolean result = service.addVehicale(vehicale);
			 if(result) {
				message = "This user has been added successfully! vehicale Name:" + vehicale.getVehicleName();
			 }
			 else {
				 message = "Failed to add the user! vehicale Name:" + vehicale.getVehicleName();
			 }
		   } catch (ClassNotFoundException | SQLException e) {
			   message = e.getMessage();
		   }
		   
		   request.setAttribute("message", message);	
			RequestDispatcher rd = request.getRequestDispatcher("add-vehicale.jsp");
			rd.forward(request, response);
		
	}

}
