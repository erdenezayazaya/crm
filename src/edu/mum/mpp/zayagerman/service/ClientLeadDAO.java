package edu.mum.mpp.zayagerman.service;

import java.util.List;

import edu.mum.mpp.zayagerman.entity.ClientLead;

public interface ClientLeadDAO {
	public void addClientLead(ClientLead ClientLead);
    public void deleteClientLead(int ClientLeadId);
    public void updateClientLead(ClientLead ClientLead);
    public List<ClientLead> getAllClientLeads();
    public ClientLead getClientLeadById(int ClientLeadId);
}
