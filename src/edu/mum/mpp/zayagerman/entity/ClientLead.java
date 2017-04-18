package edu.mum.mpp.zayagerman.entity;

public class ClientLead extends Client {
    private String source;
    private String status;
    private double amount;
    private String industry;
    private String description;
    
    public ClientLead()
    {
    	
    }
        
	public ClientLead(String source, String status, double amount, String industry, String description,
			int id, String firstName, String lastName, String email) {
		super(id, firstName, lastName, email);
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