package edu.mum.mpp.zayagerman.client;


import java.util.*;

import edu.mum.mpp.zayagerman.dto.ClientData;

/**
 * 
 */
public class ClientFactory {
	public enum ClientType {
	    LEAD,
	    OPPORTUNITY
	}
    /**
     * Default constructor
     */
    public ClientFactory() {
    }


    /**
     * @param String
     */
    public static boolean createClient(ClientType type, ClientData client) {
        // TODO implement here
    	
    	if(type.equals(ClientType.LEAD)){
    		Client lead = new Lead(client.getClientFirstName(), client.getClientLastName(), client.getClientEmail(),
    				client.getLeadSource(), client.getLeadStatus(), client.getLeadAmount(), 
    				client.getLeadIndustry(), client.getLeadDescription());
    		/*
    		 * Setup Address
    		 */
    		//Address address = new Address();
    		/*
    		 * Call DAO and return True or False of the inserction result  
    		 */
    		
    	}else if (type.equals(ClientType.OPPORTUNITY)){
    		Client opportunity = new Opportunity();
    		
    		/*
    		 * Setup Address
    		 */
    		//Address address = new Address();
    		/*
    		 * Call DAO 
    		 */
    	}
    	return true;
    }
    
  

}