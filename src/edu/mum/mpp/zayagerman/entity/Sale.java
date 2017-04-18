package edu.mum.mpp.zayagerman.entity;

import java.sql.Date;

public class Sale {
	private int idSale;
    private String typeSale;
    private double amount;
    private double percentGain;
    private double amountGain;
    private Date dateSale;
    private Client client;

	public int getIdSale() {
		return idSale;
	}
	
	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	
	public String getTypeSale() {
		return typeSale;
	}
	
	public void setTypeSale(String typeSale) {
		this.typeSale = typeSale;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getPercentGain() {
		return percentGain;
	}
	
	public void setPercentGain(double percentGain) {
		this.percentGain = percentGain;
	}
	
	public double getAmountGain() {
		return amountGain;
	}
	
	public void setAmountGain(double amountGain) {
		this.amountGain = amountGain;
	}
	
	public Date getDateSale() {
		return dateSale;
	}
	
	public void setDateSale(Date dateSale) {
		this.dateSale = dateSale;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public String toString(){
		return "Sale: TypeSale:" + getTypeSale() + " Amount:" + getAmount() + " Client: " + getClient().getFirstName();  
	}
}