package edu.mum.mpp.zayagerman.client;


import java.util.*;

/**
 * 
 */
public class Lead extends Client {

    
    public Lead(String firstName, String lastName, String email, 
    		String source, String status, double amount, String industry, String description) {
		super(firstName, lastName, email);
		
		
		if (source.equals("") || source.equals(null)) {
			this.source = "";
		} else {
			this.source = source;
		}
		
		if (status.equals("") || status.equals(null)) {
			this.status = "";
		} else {
			this.status = source;
		}
		
		this.amount = amount;
		
		if (industry.equals("") || industry.equals(null)) {
			this.industry = "";
		} else {
			this.industry = source;
		}
		
		
		if (description.equals("") || description.equals(null)) {
			this.description = "";
		} else {
			this.description = source;
		}

	}


	/**
     * 
     */
    private String source;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private double amount;

    /**
     * 
     */
    private String industry;

    /**
     * 
     */
    private String description;




}