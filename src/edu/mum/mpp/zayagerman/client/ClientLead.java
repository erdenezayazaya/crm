package edu.mum.mpp.zayagerman.client;

import javax.persistence.*;

@Entity
@Table(name = "ClientLead")
public class ClientLead extends Client {
	
	@Column(name = "source")
    private String source;
	
	@Column(name = "status")
    private String status;
	
	@Column(name = "amount")
    private double amount;
	
	@Column(name = "industry")
    private String industry;
    
	@Column(name = "description")
    private String description;
    
	public ClientLead() {
		super();
	}

	public ClientLead(String source, String status, double amount, String industry, String description) {
		super();
		this.source = source;
		this.status = status;
		this.amount = amount;
		this.industry = industry;
		this.description = description;
	}

	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getIndustry() {
		return industry;
	}
	
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}