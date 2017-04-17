package edu.mum.mpp.zayagerman.service;

import java.util.List;

import edu.mum.mpp.zayagerman.entity.Client;

public interface ClientDAO {
	public void addClient(Client client);
    public void deleteClient(int clientId);
    public void updateClient(Client client);
    public List<Client> getAllClients();
    public Client getClientById(int clientId);
}
