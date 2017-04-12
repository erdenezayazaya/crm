package edu.mum.mpp.zayagerman.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.mum.mpp.zayagerman.services.ClientService;
import edu.mum.mpp.zayagerman.services.SalesService;
import edu.mum.mpp.zayagerman.client.Client;
import edu.mum.mpp.zayagerman.client.ClientBasic;
import edu.mum.mpp.zayagerman.sale.Sale;
import edu.mum.mpp.zayagerman.sale.TypeSale;

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
				//createOpportunity(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void listSales(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		/*
		 * Temporal
		 */
		ClientBasic client = new ClientBasic(1, "German", "Segura", " gsegura@gmail.com");
		
		
		LocalDate today = LocalDate.now();
		List<Sale> listSales = new ArrayList<>();
		listSales.add(new Sale(1, TypeSale.CARINSURANCE, 5000.00, TypeSale.CARINSURANCE.percentage(), 5000.00*TypeSale.CARINSURANCE.percentage(), today, client));

		//public Sale(int idSale, String typeSale, double amount, int percentGain, double amountGain, LocalDate dateSale, ClientBasic clientBasic) {
			
		String json = new Gson().toJson(listSales);
		
		//String json = new Gson().toJson(SalesService.getList());
		response.getWriter().write("{ \"data\":" + json + " }");
	}

}
