package edu.mum.mpp.zayagerman.services;

import edu.mum.mpp.zayagerman.businessLogic.SalesLogic;
import edu.mum.mpp.zayagerman.sale.Sale;

public class SalesService {
	public static boolean createSale(int clientId, Sale sale)
	{
		return SalesLogic.createSale(clientId, sale);
	}
}
