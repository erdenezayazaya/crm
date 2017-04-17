package edu.mum.mpp.zayagerman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.hibernate.TypeMismatchException;
import org.json.JSONObject;

import com.google.gson.Gson;

import edu.mum.mpp.zayagerman.services.ClientService;
import edu.mum.mpp.zayagerman.services.SalesService;
import edu.mum.mpp.zayagerman.settings.ClientType;
import edu.mum.mpp.zayagerman.settings.TypeSale;
import edu.mum.mpp.zayagerman.entity.Client;
import edu.mum.mpp.zayagerman.entity.ClientBasic;
import edu.mum.mpp.zayagerman.entity.ClientData;
import edu.mum.mpp.zayagerman.entity.Sale;

/**
 * Servlet implementation class ManageSale
 */
@WebServlet("/ManageSale")
public class ManageSale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("list")) {
			listSales(request, response);
		}

		/*
		 * Create Client information
		 */
		if (action.equals("create")) {
			try {
				createSale(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * Data for the Sales Graphic
		 */
		
		if (action.equals("dataGraphic")) {
				dataGraphicSale(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("list")) {
			listSales(request, response);
		}

		/*
		 * Create Client information
		 */

		if (action.equals("create")) {
			try {
				createSale(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * Data for the Sales Graphic
		 */
		
		if (action.equals("dataGraphic")) {
				dataGraphicSale(request, response);
		}
	}
	
	
	
	class dataGraphic{
		TypeSale type;
		double amount;
		
		dataGraphic(TypeSale type, double amount){
			this.type = type;
			this.amount = amount;
		}
	}
	
	private void dataGraphicSale(HttpServletRequest request, HttpServletResponse response) throws IOException{
		/*
		 * Temporal
		 */
		ClientBasic client1 = new ClientBasic(1, "German", "Segura", " gsegura@gmail.com");
		ClientBasic client2 = new ClientBasic(2, "John", "McQuin", " john@gmail.com");
		ClientBasic client3 = new ClientBasic(3, "Bruce", "Lee", " lee@gmail.com");
		ClientBasic client4 = new ClientBasic(4, "Jet Li", "Segura", " jet@gmail.com");
		
		LocalDate today = LocalDate.now();
		List<Sale> listSales = new ArrayList<>();
		listSales.add(new Sale(1, TypeSale.CARINSURANCE, 5000.00, TypeSale.CARINSURANCE.percentage(), 5000.00*TypeSale.CARINSURANCE.percentage(), today, client1));
		listSales.add(new Sale(2, TypeSale.DISABILITYINSURANCE, 5000.00, TypeSale.CARINSURANCE.percentage(), 5000.00*TypeSale.DISABILITYINSURANCE.percentage(), today, client2));
		listSales.add(new Sale(3, TypeSale.HOMEINSURANCE, 5000.00, TypeSale.CARINSURANCE.percentage(), 5000.00*TypeSale.HOMEINSURANCE.percentage(), today, client3));
		listSales.add(new Sale(4, TypeSale.LIFEINSURANCE, 5000.00, TypeSale.CARINSURANCE.percentage(), 5000.00*TypeSale.LIFEINSURANCE.percentage(), today, client4));
		
		
		
		List<dataGraphic> salesData = new ArrayList<>();
		for(Sale s: listSales){
			salesData.add(new dataGraphic(s.getTypeSale(), s.getAmount()));
		}
		
			
		String json = new Gson().toJson(salesData);
		response.setContentType("application/json");
  	    response.getWriter().write(json);
  	    /*
		
		  @SuppressWarnings("rawtypes")
		List empdetails = new LinkedList();
		  JSONObject responseObj = new JSONObject();
		
		  for(Sale s: listSales){
			   empObj = new JSONObject();
	           empObj.put("name", s.getTypeSale());
	           empObj.put("empid", s.getAmount());
	           empdetails.add(empObj);
			}
		  response.getWriter().write("{ \"data\":" + json + " }");
		  responseObj.put("empdetails", empdetails);
		    out.print(responseObj.toString());
		    */
	}
	
	
	private void listSales(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		/*
		 * Temporal
		 */
		ClientBasic client1 = new ClientBasic(1, "German", "Segura", " gsegura@gmail.com");
		ClientBasic client2 = new ClientBasic(2, "John", "McQuin", " john@gmail.com");
		ClientBasic client3 = new ClientBasic(3, "Bruce", "Lee", " lee@gmail.com");
		ClientBasic client4 = new ClientBasic(4, "Jet Li", "Segura", " jet@gmail.com");
		
		LocalDate today = LocalDate.now();
		List<Sale> listSales = new ArrayList<>();
	/*	listSales.add(new Sale(1, TypeSale.CARINSURANCE, 5000.00, TypeSale.CARINSURANCE.percentage(), 5000.00*TypeSale.CARINSURANCE.percentage(), today, client1));
		listSales.add(new Sale(2, TypeSale.DISABILITYINSURANCE, 5000.00, TypeSale.CARINSURANCE.percentage(), 5000.00*TypeSale.DISABILITYINSURANCE.percentage(), today, client2));
		listSales.add(new Sale(3, TypeSale.HOMEINSURANCE, 5000.00, TypeSale.CARINSURANCE.percentage(), 5000.00*TypeSale.HOMEINSURANCE.percentage(), today, client3));
		listSales.add(new Sale(4, TypeSale.LIFEINSURANCE, 5000.00, TypeSale.CARINSURANCE.percentage(), 5000.00*TypeSale.LIFEINSURANCE.percentage(), today, client4));*/
			
		String json = new Gson().toJson(listSales);
		
		//String json = new Gson().toJson(SalesService.getList());
		response.getWriter().write("{ \"data\":" + json + " }");
	}
	
	private void createSale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		TypeSale typeNewSale = TypeSale.valueOf(request.getParameter("typeSale"));
		Double amountNewSale = Double.valueOf(request.getParameter("OpporAmount"));
		int idClient = Integer.valueOf(request.getParameter("idClient"));
		
		Sale sale = new Sale();/*
		sale.setTypeSale(typeNewSale);*/
		//sale.setClientBasic(ClientService.getclient(idClient));
		sale.setAmount(amountNewSale);
		sale.setPercentGain(typeNewSale.percentage());
		sale.setAmountGain(typeNewSale.percentage() * amountNewSale);
		LocalDate today = LocalDate.now();
		sale.setDateSale(today);
		
		PrintWriter out = response.getWriter();
		out.println(sale);
		
		
		SalesService.createSale(idClient, sale);
		
		response.sendRedirect("modules/success.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("modules/saleCreation.jsp");
		rd.forward(request, response);
	}

}
