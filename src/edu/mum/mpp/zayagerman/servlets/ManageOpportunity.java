package edu.mum.mpp.zayagerman.servlets;

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

import edu.mum.mpp.zayagerman.client.ClientBasic;
import edu.mum.mpp.zayagerman.client.ClientOpportunity;
import edu.mum.mpp.zayagerman.client.ClientType;
import edu.mum.mpp.zayagerman.client.Stage;
import edu.mum.mpp.zayagerman.dto.ClientData;
import edu.mum.mpp.zayagerman.sale.Sale;
import edu.mum.mpp.zayagerman.sale.TypeSale;
import edu.mum.mpp.zayagerman.services.ClientService;

/**
 * Servlet implementation class ManageOpportunity
 */
@WebServlet("/ManageOpportunity")
public class ManageOpportunity extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		//String json = new Gson().toJson(ClientService.getOportunities());
		/*
		 * Temporal
		 */
	
		LocalDate today = LocalDate.now();
		List<ClientOpportunity> listOppor = new ArrayList<>();
		listOppor.add(new ClientOpportunity(1, "German", "Segura", " gsegura@gmail.com", Stage.NEGOTIATION, 5000.00, 10, today, "Description1"));
		listOppor.add(new ClientOpportunity(2, "John", "McQuin", " john@gmail.com", Stage.NEGOTIATION, 5000.00, 20, today, "Description2"));
		listOppor.add(new ClientOpportunity(3, "Bruce", "Lee", " lee@gmail.com", Stage.NEGOTIATION, 5000.00, 25, today, "Description3"));
		listOppor.add(new ClientOpportunity(4, "Jet Li", "Segura", " jet@gmail.com", Stage.NEGOTIATION, 5000.00, 80, today, "Description4"));
		String json = new Gson().toJson(listOppor);
		
		
		
		response.getWriter().write("{ \"data\":" + json + " }");
	}

	private void createOpportunity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		ClientData client = new ClientData();
		client.setClientFirstName(request.getParameter("clientFirstName"));
		client.setClientLastName(request.getParameter("clientLastName"));
		client.setClientEmail(request.getParameter("clientEmail"));

		client.setOpporStage(request.getParameter("OpporStage"));
		client.setOpporAmount(Double.parseDouble(request.getParameter("OpporAmount")));
		client.setOpporProbability(Integer.parseInt(request.getParameter("OpporProbability")));
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date closeDateOppor = (Date) formatter.parse(request.getParameter("OpporCloseDate"));
		client.setOpporCloseDate(closeDateOppor);
		client.setOpporDescription(request.getParameter("OpporDescription"));

		ClientService.createClient(ClientType.OPPORTUNITY, client);

		// response.sendRedirect("modules/success.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("modules/leadCreation.jsp");
		rd.forward(request, response);
	}
}
