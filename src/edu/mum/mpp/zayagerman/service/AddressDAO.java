package edu.mum.mpp.zayagerman.service;

import java.util.List;

import edu.mum.mpp.zayagerman.entity.Address;

public interface AddressDAO {
	public void addAddress(Address address);
    public void deleteAddress(int addresstId);
    public void updateAddress(Address address);
    public List<Address> getAllAddresss();
    public Address getAddressById(int addressId);
}
