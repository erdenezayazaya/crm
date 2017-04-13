package edu.mum.mpp.zayagerman.client;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import edu.mum.mpp.zayagerman.activity.Activity;
import edu.mum.mpp.zayagerman.sale.Sale;

@Entity
@Table(name = "ClientBasic")
public class ClientBasic extends Client{
	
	private List<Address> addressList;
	private List<Activity> activityList;
	private List<Sale> saleList;
	
	public ClientBasic(int id, String firstName, String lastName, String email)
	{
		super(id, firstName, lastName, email);
		addressList = new ArrayList<>();
		activityList = new ArrayList<>();
		saleList = new ArrayList<>();
	}
	
	public void addAddressList(Address address)
	{
		if(addressList != null) return;
		
		addressList.add(address);
	}
	
	public void addActivityList(Activity activity)
	{
		if(activityList != null) return;
		
		activityList.add(activity);
	}
	
	public void addSaleList(Sale sale)
	{
		if(saleList != null) return;
		
		saleList.add(sale);		
	}
	
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public List<Activity> getActivityList() {
		return activityList;
	}
	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}
	public List<Sale> getSaleList() {
		return saleList;
	}
	public void setSaleList(List<Sale> saleList) {
		this.saleList = saleList;
	}
}
