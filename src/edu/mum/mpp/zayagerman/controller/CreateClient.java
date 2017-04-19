package edu.mum.mpp.zayagerman.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.mum.mpp.zayagerman.businessLogic.ClientFactory;
import edu.mum.mpp.zayagerman.dao.ClientLeadDAOImpl;
import edu.mum.mpp.zayagerman.entity.Client;
import edu.mum.mpp.zayagerman.entity.ClientData;
import edu.mum.mpp.zayagerman.entity.ClientLead;
import edu.mum.mpp.zayagerman.service.ClientLeadDAO;
import edu.mum.mpp.zayagerman.settings.ClientType;

/**
 * Servlet implementation class CreateClient
 */
@WebServlet(description = "Servlet for creating a client", urlPatterns = { "/CreateClient" })
public class CreateClient extends HttpServlet {
	
	private ClientLeadDAO dao;
	
	public CreateClient(){
		dao = new ClientLeadDAOImpl();
	}
	
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
	}
	
	private void listLeads(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    
	    /*
	     * GET ALL CLIENTS
	     */
	    List<ClientLead> leads = new ArrayList<ClientLead>();
	    leads = dao.getAllClientLeads();
	    
	    String json = new Gson().toJson(leads );
	    response.getWriter().write("{ \"data\":"   + json + " }"); 
	}
	
	private void createClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Retrieve object Client from de Factory
		 */
		ClientLead client = (ClientLead)ClientFactory.createClient(ClientType.LEAD);

		client.setFirstName(request.getParameter("clientFirstName"));
		client.setLastName(request.getParameter("clientLastName"));
		client.setEmail(request.getParameter("clientEmail"));
		
		client.setAmount(Double.valueOf(request.getParameter("LeadAmount")));
		client.setSource(request.getParameter("leadSource"));
		client.setStatus(request.getParameter("leadStatus"));
		client.setIndustry(request.getParameter("leadIndustry"));
		client.setDescription(request.getParameter("leadDescription"));
		
		dao.addClientLead( client);
		
		response.sendRedirect("modules/success.jsp");
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
