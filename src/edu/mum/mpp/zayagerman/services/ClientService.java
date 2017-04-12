package edu.mum.mpp.zayagerman.services;

import java.util.*;


import edu.mum.mpp.zayagerman.client.ClientFactory;
import edu.mum.mpp.zayagerman.client.ClientFactory.ClientType;
import edu.mum.mpp.zayagerman.client.Lead;
import edu.mum.mpp.zayagerman.client.Opportunity;
import edu.mum.mpp.zayagerman.dto.ClientData;


public class ClientService {
	public static boolean createClient(ClientType type, ClientData client){
		return ClientFactory.createClient(type, client);
	}
	
	public ClientData getclient(int id){
		
		return null;
	}
	
	public static List<Lead> getLeads(){
		
		List<Lead> leads = new ArrayList<Lead>();
		leads.add(new Lead("German", "Segura", " gsegura@gmail.com", "aa", "aa", 3.0, "a", "aa" ));
		leads.add(new Lead("Charlei", "Segura", " gsegura@gmail.com", "aa", "aa", 3.0, "a", "aa" ));
		leads.add(new Lead("Zaya", "Segura", " gsegura@gmail.com", "aa", "aa", 3.0, "a", "aa" ));
		leads.add(new Lead("Tom", "Segura", " gsegura@gmail.com", "aa", "aa", 3.0, "a", "aa" ));
		leads.add(new Lead("John", "Segura", " gsegura@gmail.com", "aa", "aa", 3.0, "a", "aa" ));
		
		
		
		return leads;
	}
	
	public List<Opportunity> getOportunities(){
		return null;
	}
	
	
}
