package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithnuwanthika.cabservice.model.CustomerBookings;
import com.codewithnuwanthika.cabservice.service.CustomerBookingService;


/**
 * Servlet implementation class ViewCustomerBookingServlet
 */
public class ViewCustomerBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomerBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
			
			if(action.equals("all")) {
				getAllCustomerBookings(request,response);
			}
	}

	private void getAllCustomerBookings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message ="";
		CustomerBookingService service = new CustomerBookingService();
		   
		  
		try {
			List<CustomerBookings> customerBookings = service.getAllCustomerBookings();
			
			if(customerBookings.isEmpty()){
				message = "There is no any booking to show";
			}
			
			request.setAttribute("customerBookingList", customerBookings);
		    
		} catch (ClassNotFoundException | SQLException e) {
			message =e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("View-CustomerBooking.jsp");
		rd.forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("delete")) {
			deleteCustomerBooking(request, response);
			
		}
	}


	private void deleteCustomerBooking(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = "";
    	int bookingID = Integer.parseInt(request.getParameter("bookingID"));
    	 CustomerBookingService service = new  CustomerBookingService();
    	try {
			service.deleteCustomerBooking(bookingID);
			
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
		}
   
    	response.sendRedirect("/cab-service/ViewCustomerBookingServlet?action=all");
		
	}	

}
