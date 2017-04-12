package edu.mum.mpp.zayagerman.client;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ClientOpportunity")
public final class ClientOpportunity extends Client {

	@Column(name = "stage")
    private String stage;
	
	@Column(name = "amount")
    private double amount;
	
	@Column(name = "probability")
    private int probability;
	
	@Column(name = "closeDate")
    private LocalDate closeDate;
	
	@Column(name = "description")
    private String description;
    
	public ClientOpportunity() {
		super();
	}

	public ClientOpportunity(String stage, double amount, int probability, LocalDate closeDate, String description) {
		super();
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
	
	public LocalDate getCloseDate() {
		return closeDate;
	}
	
	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}