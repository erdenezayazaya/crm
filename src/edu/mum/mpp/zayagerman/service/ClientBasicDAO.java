package edu.mum.mpp.zayagerman.service;

import java.util.List;

import edu.mum.mpp.zayagerman.entity.ClientBasic;

public interface ClientBasicDAO {
	public void addClientBasic(ClientBasic ClientBasic);
    public void deleteClientBasic(int ClientBasicId);
    public void updateClientBasic(ClientBasic ClientBasic);
    public List<ClientBasic> getAllClientBasics();
    public ClientBasic getClientBasicById(int ClientBasicId);
}
