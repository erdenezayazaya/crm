package edu.mum.mpp.zayagerman.services;

import edu.mum.mpp.zayagerman.businessLogic.AddressLogic;
import edu.mum.mpp.zayagerman.client.Address;

public class AddressService {
	public static boolean createActivities(int clientId, Address address)
	{
		return AddressLogic.createActivities(clientId, address);
	}
}
