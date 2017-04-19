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
import org.json.JSONObject;

import com.google.gson.Gson;

import edu.mum.mpp.zayagerman.settings.ClientType;
import edu.mum.mpp.zayagerman.settings.TypeSale;
import edu.mum.mpp.zayagerman.dao.SaleDAOImpl;
import edu.mum.mpp.zayagerman.entity.Client;
import edu.mum.mpp.zayagerman.entity.ClientBasic;
import edu.mum.mpp.zayagerman.entity.ClientData;
import edu.mum.mpp.zayagerman.entity.Sale;
import edu.mum.mpp.zayagerman.service.SaleDAO;

/**
 * Servlet implementation class ManageSale
 */
@WebServlet("/ManageSale")
public class ManageSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SaleDAO dao;
	
	public ManageSale(){
		dao = new SaleDAOImpl();
	}
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
		String type;
		double amount;
		
		dataGraphic(String type, double amount){
			this.type = type;
			this.amount = amount;
		}
	}
	
	private void dataGraphicSale(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String json = new Gson().toJson(dao.dataGraphicSales());
		response.setContentType("application/json");
		response.getWriter().write(json);
		//response.getWriter().write("{ \"data\":" + json + " }");
		
  	    
	}
	
	
	private void listSales(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
	
		List<Sale> listSales = new ArrayList<>();
		listSales = dao.getAllSales();
		String json = new Gson().toJson(listSales);
		response.getWriter().write("{ \"data\":" + json + " }");
	}
	
	private void createSale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		TypeSale typeNewSale = TypeSale.valueOf(request.getParameter("typeSale"));
		Double amountNewSale = Double.valueOf(request.getParameter("OpporAmount"));
		int idClient = Integer.valueOf(request.getParameter("idClient"));
		
		Client client = new Client();
		client.setId(idClient);
		
		Sale sale = new Sale();
		sale.setClient(client);
		sale.setAmount(amountNewSale);
		sale.setTypeSale(typeNewSale);
		sale.setAmountGain(typeNewSale.percentage() * amountNewSale);
		sale.setDateSale(null);
		sale.setPercentGain(typeNewSale.percentage());
		
		dao.addSale(sale);
		
		response.sendRedirect("modules/salesCreation.jsp");
		//RequestDispatcher rd = request.getRequestDispatcher("modules/saleCreation.jsp");
		//rd.forward(request, response);
	}

}
