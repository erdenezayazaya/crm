package edu.mum.mpp.zayagerman.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.mum.mpp.zayagerman.businessLogic.ClientFactory;
import edu.mum.mpp.zayagerman.dao.ClientOpportunityDAOImpl;
import edu.mum.mpp.zayagerman.entity.ClientBasic;
import edu.mum.mpp.zayagerman.entity.ClientData;
import edu.mum.mpp.zayagerman.entity.ClientLead;
import edu.mum.mpp.zayagerman.entity.ClientOpportunity;
import edu.mum.mpp.zayagerman.entity.Sale;
import edu.mum.mpp.zayagerman.service.ClientOpportunityDAO;
import edu.mum.mpp.zayagerman.settings.ClientType;
import edu.mum.mpp.zayagerman.settings.Stage;
import edu.mum.mpp.zayagerman.settings.TypeSale;

/**
 * Servlet implementation class ManageOpportunity
 */
@WebServlet("/ManageOpportunity")
public class ManageOpportunity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientOpportunityDAO dao;
	
	ManageOpportunity(){
		dao = new ClientOpportunityDAOImpl();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("list")) {
			listOpportunities(request, response);
		}

		/*
		 * Create Client information
		 */
		if (action.equals("create")) {
			try {
				createOpportunity(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	private void listOpportunities(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		List<ClientOpportunity> listOppor = dao.getAllClientOpportunitys();
		String json = new Gson().toJson(listOppor);
		response.getWriter().write("{ \"data\":" + json + " }");
	}

	private void createOpportunity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		ClientOpportunity client = (ClientOpportunity)ClientFactory.createClient(ClientType.OPPORTUNITY);
		client.setFirstName(request.getParameter("clientFirstName"));
		client.setLastName(request.getParameter("clientLastName"));
		client.setEmail(request.getParameter("clientEmail"));
		client.setStage(request.getParameter("OpporStage"));
		client.setAmount(Double.parseDouble(request.getParameter("OpporAmount")));
		client.setProbability(Integer.parseInt(request.getParameter("OpporProbability")));
		/*
		 * DATE TEMP
		 */
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date closeDateOppor = (Date) formatter.parse(request.getParameter("OpporCloseDate"));
		client.setCloseDate((java.sql.Date) closeDateOppor);
		client.setDescription(request.getParameter("OpporDescription"));

		dao.addClientOpportunity(client);

		// response.sendRedirect("modules/success.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("modules/leadCreation.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("list")) {
			listOpportunities(request, response);
		}
	}

}

