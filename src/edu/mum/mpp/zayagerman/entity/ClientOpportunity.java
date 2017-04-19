package edu.mum.mpp.zayagerman.entity;

import java.sql.Date;

public final class ClientOpportunity extends Client {
	private int clientOpportunityId;
    private String stage;
    private double amount;
    private int probability;
    private Date closeDate;
    private String description;
    
    public ClientOpportunity() {}
    
	public ClientOpportunity(String stage, double amount, int probability, Date closeDate, String description,
			int id, String firstName, String lastName, String email) {
		super(id, firstName, lastName, email);		
		this.stage = stage;
		this.amount = amount;
		this.probability = probability;
		this.closeDate = closeDate;
		this.description = description;
	}

	public String getStage() {
		return stage;
	}
	
	public void setStage(String stage) {
		this.stage = stage;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getProbability() {
		return probability;
	}
	
	public void setProbability(int probability) {
		this.probability = probability;
	}
	
	public Date getCloseDate() {
		return closeDate;
	}
	
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public int getClientOpportunityId() {
		return clientOpportunityId;
	}

	public void setClientOpportunityId(int clientOpportunityId) {
		this.clientOpportunityId = clientOpportunityId;
	}
}


