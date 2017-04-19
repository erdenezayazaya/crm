package edu.mum.mpp.zayagerman.businessLogic;

import edu.mum.mpp.zayagerman.entity.Client;
import edu.mum.mpp.zayagerman.entity.ClientLead;
import edu.mum.mpp.zayagerman.entity.ClientOpportunity;
import edu.mum.mpp.zayagerman.settings.ClientType;

final public class ClientFactory {
	
	
    private ClientFactory() { }
    
    public static Client createClient(ClientType type){
    	if(type.equals(ClientType.LEAD)){
    		return new ClientLead();
    	}
    	if(type.equals(ClientType.OPPORTUNITY)){
    		return new ClientOpportunity();
    	}
		return null;
    }
    
}