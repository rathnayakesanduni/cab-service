package com.codewithnuwanthhika.cabservice.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithnuwanthika.cabservice.model.Feedback;
import com.codewithnuwanthika.cabservice.service.FeedbackService;

/**
 * Servlet implementation class FeedbackServlet
 */
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
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
		
		if(action.equals("add")) {
			addFeedback(request,response);
		}
	}

	private void addFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String message = "";
		   FeedbackService service = new FeedbackService();
		   
		   Feedback feedback= new Feedback();
		   feedback.setCustomer_Name(request.getParameter("customer_Name"));
		   feedback.setDescrption(request.getParameter("descrption"));
		  
		   try {
			boolean result = service.addFeedback(feedback);
			 if(result) {
				message = "This Customer has been added successfully! Customer Name:" + feedback.getCustomer_Name();
			 }
			 else {
				 message = "Failed to add the Customer! Customer Name:" + feedback.getCustomer_Name();
			 }
		   } catch (ClassNotFoundException | SQLException e) {
			   message = e.getMessage();
		   }
		   
		   request.setAttribute("message", message);	
			RequestDispatcher rd = request.getRequestDispatcher("feedback.jsp");
			rd.forward(request, response);
		
	}

}
