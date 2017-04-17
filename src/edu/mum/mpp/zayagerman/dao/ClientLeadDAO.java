package edu.mum.mpp.zayagerman.dao;

import java.util.List;
import edu.mum.mpp.zayagerman.client.ClientLead;

public interface ClientLeadDAO {
	public void addClientLead(ClientLead ClientLead);
    public void deleteClientLead(int ClientLeadId);
    public void updateClientLead(ClientLead ClientLead);
    public List<ClientLead> getAllClientLeads();
    public ClientLead getClientLeadById(int ClientLeadId);
}
