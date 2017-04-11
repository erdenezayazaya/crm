package edu.mum.mpp.zayagerman.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		/*
		 * Retrieve Client information
		 */
		ClientData client = new ClientData();
		client.setClientFirstName(request.getParameter("clientFirstName"));
		client.setClientLastName(request.getParameter("clientLastName"));
		client.setClientEmail(request.getParameter("clientEmail"));
		
		client.setLeadAmount(Double.parseDouble(request.getParameter("LeadAmount")));
		client.setLeadSource(request.getParameter("leadSource"));
		client.setLeadStatus(request.getParameter("leadStatus"));
		client.setLeadIndustry(request.getParameter("leadIndustry"));
		client.setLeadDescription(request.getParameter("LeadDescription"));
		
		ClientService.createClient(ClientType.LEAD, client);
		
		//HttpSession session = request.getSession();
		//session.setAttribute("test1", "testvalue");
		//session.getAttribute("test1");
		
		//Context
		//ServletContext context = request.getServletContext();
		//context.setAttribute(arg0, arg1);
		
		//init
		//Create parameters in init
		//
		
		doGet(request, response);
	}

}
