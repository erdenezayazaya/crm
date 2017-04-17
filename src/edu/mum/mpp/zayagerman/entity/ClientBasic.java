package edu.mum.mpp.zayagerman.entity;

import java.util.List;


public class ClientBasic extends Client{
	
	private List<Address> addressList;
	private List<Activity> activityList;
	private List<Sale> saleList;

	public void addAddressList(Address address)
	{
		addressList.add(address);
	}
	
	public void addActivityList(Activity activity)
	{
		activityList.add(activity);
	}
	
	public void addSaleList(Sale sale)
	{
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
