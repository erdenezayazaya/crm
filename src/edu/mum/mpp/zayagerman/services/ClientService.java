package edu.mum.mpp.zayagerman.services;

import java.util.*;

import edu.mum.mpp.zayagerman.client.ClientBasic;
import edu.mum.mpp.zayagerman.client.ClientFactory;
import edu.mum.mpp.zayagerman.client.ClientLead;
import edu.mum.mpp.zayagerman.client.ClientOpportunity;
import edu.mum.mpp.zayagerman.client.ClientType;
import edu.mum.mpp.zayagerman.dto.ClientData;

public class ClientService {
	public static boolean createClient(ClientType type, ClientData client){
		return ClientFactory.createClient(type, client);
	}
	
	public static ClientBasic getclient(int id){
		return ClientFactory.getClient(id);
	}
	
    public static List<ClientLead> getLeads(){
    	return ClientFactory.getLeads();
	}
    
    public static List<ClientOpportunity> getOportunities(){
    	return ClientFactory.getOportunities();
    }
	
    public static List<ClientBasic> getClientBasics()
    {
    	return ClientFactory.getClientBasics();
    }
}
