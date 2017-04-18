package edu.mum.mpp.zayagerman.dao;

import java.sql.Connection;
import java.util.List;

import edu.mum.mpp.zayagerman.entity.ClientBasic;
import edu.mum.mpp.zayagerman.service.ClientBasicDAO;
import edu.mum.mpp.zayagerman.settings.DBUtil;

public class ClientBasicDAOImpl implements ClientBasicDAO{
	private Connection conn;
	
    public ClientBasicDAOImpl() {
        conn = DBUtil.getConnection();
    }
    
	@Override
	public void addClientBasic(ClientBasic clientBasic) {
	
	}

	@Override
	public void deleteClientBasic(int ClientBasicId) {
	
	}

	@Override
	public void updateClientBasic(ClientBasic ClientBasic) {
		
	}

	@Override
	public List<ClientBasic> getAllClientBasics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientBasic getClientBasicById(int ClientBasicId) {
		// TODO Auto-generated method stub
		return null;
	}

}
