package edu.mum.mpp.zayagerman.service;

import java.util.List;

import com.google.gson.JsonElement;

import edu.mum.mpp.zayagerman.entity.ClientOpportunity;
import edu.mum.mpp.zayagerman.entity.DataGraphicOppo;

public interface ClientOpportunityDAO {
	public void addClientOpportunity(ClientOpportunity clientOpportunity);
    public void deleteClientOpportunity(int clientOpportunityId);
    public void updateClientOpportunity(ClientOpportunity clientOpportunity);
    public List<ClientOpportunity> getAllClientOpportunitys();
    public ClientOpportunity getClientOpportunityById(int clientOpportunityId);
	public List<DataGraphicOppo> listOpporByStage();
}
