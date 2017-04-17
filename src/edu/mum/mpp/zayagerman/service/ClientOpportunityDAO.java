package edu.mum.mpp.zayagerman.service;

import java.util.List;

public interface ClientOpportunityDAO {
	public void addClientOpportunity(ClientOpportunityDAO clientOpportunity);
    public void deleteClientOpportunity(int clientOpportunityId);
    public void updateClientOpportunity(ClientOpportunityDAO clientOpportunity);
    public List<ClientOpportunityDAO> getAllClientOpportunitys();
    public ClientOpportunityDAO getClientOpportunityById(int clientOpportunityId);
}
