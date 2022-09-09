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
 * Servlet implementation class CustomerBookServlet
 */
public class CustomerBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
			
			if(action.equals("all")) {
				getCustomerBookings(request,response);
			}
	}

	private void getCustomerBookings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message ="";
		CustomerBookingService service = new CustomerBookingService();
		   
		  
		try {
			List<CustomerBookings> customerBookings1 = service.getCustomerBookings();
			
			if(customerBookings1.isEmpty()){
				message = "There is no any booking to show";
			}
			
			request.setAttribute("customerBookList", customerBookings1);
		    
		} catch (ClassNotFoundException | SQLException e) {
			message =e.getMessage();
		}
		
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewBook.jsp");
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
