package edu.mum.mpp.zayagerman.service;

import java.util.List;

import edu.mum.mpp.zayagerman.entity.Sale;

public interface SaleDAO {
	public void addSale(Sale sale);
    public void deleteSale(int saleId);
    public void updateSale(Sale sale);
    public List<Sale> getAllSales();
    public Sale getSaleById(int saleId);
}
