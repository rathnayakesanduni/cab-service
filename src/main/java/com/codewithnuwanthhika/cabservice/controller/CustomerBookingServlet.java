package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithnuwanthika.cabservice.model.CustomerBookings;
import com.codewithnuwanthika.cabservice.service.CustomerBookingService;


/**
 * Servlet implementation class CustomerBookingServlet
 */
public class CustomerBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
		
		if(action.equals("add")) {
			addCustomerBooking(request,response);
		}
	}


	private void addCustomerBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String message = "";
		   CustomerBookingService service = new CustomerBookingService();
		   
		   CustomerBookings customerBooking= new CustomerBookings();
		   customerBooking.setCustomerName(request.getParameter("customerName"));
		   customerBooking.setPickUpLocation(request.getParameter("pickUpLocation"));
		   customerBooking.setDropUpLocation(request.getParameter("dropUpLocation"));
		   customerBooking.setVehicleType(request.getParameter("vehicleType"));
		   
		   try {
			boolean result = service.addCustomerBooking(customerBooking);
			 if(result) {
				message = "This Customer has been added successfully! Customer Name:" + customerBooking.getCustomerName();
			 }
			 else {
				 message = "Failed to add the Customer! Customer Name:" + customerBooking.getCustomerName();
			 }
		   } catch (ClassNotFoundException | SQLException e) {
			   message = e.getMessage();
		   }
		   
		   request.setAttribute("message", message);	
			RequestDispatcher rd = request.getRequestDispatcher("User.jsp");
			rd.forward(request, response);
		
	}

}
