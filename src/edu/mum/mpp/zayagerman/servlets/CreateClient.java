package edu.mum.mpp.zayagerman.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpContext;

import edu.mum.mpp.zayagerman.client.ClientFactory.ClientType;
import edu.mum.mpp.zayagerman.dto.ClientData;
import edu.mum.mpp.zayagerman.services.ClientService;

/**
 * Servlet implementation class CreateClient
 */
@WebServlet(description = "Servlet for creating a client", urlPatterns = { "/CreateClient" })
public class CreateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String action = request.getParameter("action");
		
		if(action.equals("listLeads")){
			listLeads(request, response);
		}
		
		//PrintWriter out = response.getWriter();
		//out.println("TestServlet says hi<br/>");
		
		/*
		 * Create Client information
		 */
		
		if(action.equals("createLead")){
			createClient(request, response);
		}
		
		
		//HttpSession session = request.getSession();
		//session.setAttribute("test1", "testvalue");
		//session.getAttribute("test1");
		
		//Context
		//ServletContext context = request.getServletContext();
		//context.setAttribute(arg0, arg1);
		
		//init
		//Create parameters in init
		//
		
		//doGet(request, response);
		return;
	}
	
	private void listLeads(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    
	    
	    String json = new Gson().toJson(ClientService.getLeads() );
	    response.getWriter().write("{ \"data\":"   + json + " }"); 
	}
	
	private void createClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientData client = new ClientData();
		client.setClientFirstName(request.getParameter("clientFirstName"));
		client.setClientLastName(request.getParameter("clientLastName"));
		client.setClientEmail(request.getParameter("clientEmail"));
		
		client.setLeadAmount(3.0);
		//client.setLeadAmount(Double.parseDouble(request.getParameter("LeadAmount")));
		client.setLeadSource(request.getParameter("leadSource"));
		client.setLeadStatus(request.getParameter("leadStatus"));
		client.setLeadIndustry(request.getParameter("leadIndustry"));
		client.setLeadDescription(request.getParameter("leadDescription"));
		
		ClientService.createClient(ClientType.LEAD, client);
		
		//response.sendRedirect("modules/success.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("modules/leadCreation.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("listLeads")){
			listLeads(request, response);
		}
	}
}
