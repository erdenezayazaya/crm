package edu.mum.mpp.zayagerman.entity;

import java.time.LocalDate;

public final class ClientOpportunity extends Client {
    private String stage;
    private double amount;
    private int probability;
    private LocalDate closeDate;
    private String description;

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