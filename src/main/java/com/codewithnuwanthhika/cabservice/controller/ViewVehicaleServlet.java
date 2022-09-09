package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithnuwanthika.cabservice.model.Vehicale;
import com.codewithnuwanthika.cabservice.service.VehicaleService;

/**
 * Servlet implementation class ViewVehicaleServlet
 */
public class ViewVehicaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewVehicaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
		
		if(action.equals("all")) {
			getAllVehicale(request,response);
		}
		else {
			getSpecificVehicale(request,response);
		}
		
	}

	

	private void getSpecificVehicale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String message = "";
		  VehicaleService service = new  VehicaleService();
		   int vehicleID= Integer.parseInt(request.getParameter("vehicleID"));
		   
		   Vehicale vehicale= new Vehicale();
		   try {
			   vehicale = service.getTheVehicaleByvehicleID(vehicleID);
			    if(vehicale.getVehicleName().isEmpty() ) {
			    	message = "There is no any user under s Id:" +vehicleID;
			    }
		   } catch (ClassNotFoundException | SQLException e) {
			   message = e.getMessage();
		   }
		   
		    request.setAttribute("message", message);
		    request.setAttribute("vehicale", vehicale);
			RequestDispatcher rd = request.getRequestDispatcher("update-vehicale.jsp");
			rd.forward(request, response);
		
	}

	private void getAllVehicale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message ="";
		VehicaleService service = new  VehicaleService();
		try {
			List<Vehicale> vehicales = service.getAllVehicale();
			
			if(vehicales.isEmpty()){
				message = "There is no any user to show";
			}
			
			request.setAttribute("vehicaleList", vehicales);
		    
		} catch (ClassNotFoundException | SQLException e) {
			message =e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("view-vehicales.jsp");
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
