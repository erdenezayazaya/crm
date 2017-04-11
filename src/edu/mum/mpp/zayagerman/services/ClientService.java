package edu.mum.mpp.zayagerman.services;

import edu.mum.mpp.zayagerman.client.Client;
import edu.mum.mpp.zayagerman.client.ClientFactory;
import edu.mum.mpp.zayagerman.client.ClientFactory.ClientType;
import edu.mum.mpp.zayagerman.dto.ClientData;

public class ClientService {
	public static boolean createClient(ClientType type, ClientData client){
		return ClientFactory.createClient(type, client);
	}
	
	public ClientData getclient(int id){
		
		return null;
	}
}
