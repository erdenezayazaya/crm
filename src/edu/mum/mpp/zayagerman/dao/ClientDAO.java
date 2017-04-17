package edu.mum.mpp.zayagerman.dao;

import java.util.List;
import edu.mum.mpp.zayagerman.client.Client;

public interface ClientDAO {
	public void addClient(Client client);
    public void deleteClient(int clientId);
    public void updateClient(Client client);
    public List<Client> getAllClients();
    public Client getClientById(int clientId);
}
