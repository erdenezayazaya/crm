package edu.mum.mpp.zayagerman.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import edu.mum.mpp.zayagerman.client.ClientBasic;
import edu.mum.mpp.zayagerman.client.ClientLead;
import edu.mum.mpp.zayagerman.client.ClientType;
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
		
		/*if(action.equals("listLeads")){
			listLeads(request, response);

		}*/
		
		//PrintWriter out = response.getWriter();
		//out.println("TestServlet says hi<br/>");

		//}


		/*
		 * Create Client information
		 */
		
		//if(action.equals("createLead")){
		//	createClient(request, response);
			//}
		
		
		
		//return;
	}
	
	private void listLeads(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    
	    /*
	     * TEMPORAL
	     */
	    List<ClientLead> leads = new ArrayList<ClientLead>();
	    /*
		leads.add(new ClientLead("German", "Segura", " gsegura@gmail.com", "aa", "aa", 3.0, "a", "aa" ));
		leads.add(new ClientLead("Charlei", "Segura", " gsegura@gmail.com", "aa", "aa", 3.0, "a", "aa" ));
		leads.add(new ClientLead("Zaya", "Segura", " gsegura@gmail.com", "aa", "aa", 3.0, "a", "aa" ));
		leads.add(new ClientLead("Tom", "Segura", " gsegura@gmail.com", "aa", "aa", 3.0, "a", "aa" ));
		leads.add(new ClientLead("John", "Segura", " gsegura@gmail.com", "aa", "aa", 3.0, "a", "aa" ));
	    */
	    /*
	     * 
	     */
	    
	    String json = new Gson().toJson(ClientService.getLeads() );
	    response.getWriter().write("{ \"data\":"   + json + " }"); 
	}
	
	private void createClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ClientData client = new ClientData();
//		client.setClientFirstName(request.getParameter("clientFirstName"));
//		client.setClientLastName(request.getParameter("clientLastName"));
//		client.setClientEmail(request.getParameter("clientEmail"));
//		
//	//	client.setLeadAmount(3.0);
//	//	//client.setLeadAmount(Double.parseDouble(request.getParameter("LeadAmount")));
////		client.setLeadSource(request.getParameter("leadSource"));
////		client.setLeadStatus(request.getParameter("leadStatus"));
//		/*client.setLeadIndustry(request.getParameter("leadIndustry"));
//		client.setLeadDescription(request.getParameter("leadDescription"));*/
//		
//		ClientService.createClient(ClientType.LEAD, client);
//		
//		//response.sendRedirect("modules/success.jsp");
//		RequestDispatcher rd = request.getRequestDispatcher("modules/leadCreation.jsp");
//		rd.forward(request, response);
		
		
	/*	 String userName = "dw";
	        String password = "dw";
	        String email = "dw";
	        String phone = "dw";
	        String city = "dw";
	 
	        HttpSession session = request.getSession(true);
	       
	        try {
	            UserDAO userDAO = new UserDAO();
	            userDAO.addUserDetails(userName, password, email, phone, city);
	            response.sendRedirect("Success");
	        } catch (Exception e) {
	 
	            e.printStackTrace();
	        }*/
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//		
//		if(action.equals("listLeads")){
//			listLeads(request, response);
//		}
		
		 String userName = "dw";
	        String password = "dw";
	        String email = "dw";
	        String phone = "dw";
	        String city = "dw";
	        
	        ClientData lead = new ClientData();
	        lead.setClientFirstName("dwdw");
	 
	        HttpSession session = request.getSession(true);
	       
	        try {
	           ClientService.createClient(ClientType.LEAD, lead);
	        } catch (Exception e) {
	 
	            e.printStackTrace();
	        }
	}
}
