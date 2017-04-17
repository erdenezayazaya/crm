package edu.mum.mpp.zayagerman.dao;

import java.util.List;
import edu.mum.mpp.zayagerman.client.ClientBasic;

public interface ClientBasicDAO {
	public void addClientBasic(ClientBasic ClientBasic);
    public void deleteClientBasic(int ClientBasicId);
    public void updateClientBasic(ClientBasic ClientBasic);
    public List<ClientBasic> getAllClientBasics();
    public ClientBasic getClientBasicById(int ClientBasicId);
}
