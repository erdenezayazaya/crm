package edu.mum.mpp.zayagerman.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {

	@Column(name = "type")
    private String type;
	
	@Column(name = "address")
    private String address;
	
	@Column(name = "phone")
    private String phone;
	
	@Column(name = "city")
    private String city;
	
	@Column(name = "state")
    private String state;
	
	@Column(name = "zipCode")
    private int zipCode;
	
	@Column(name = "country")
    private String country;
	
	@Column(name = "clientBasic")
    private ClientBasic clientBasic;
    
    public Address() {
    }
    
    public Address(String type, String address, String phone, String city, String state, int zipCode, String country, ClientBasic clientBasic) {
		super();
		this.type = type;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.clientBasic = clientBasic;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public ClientBasic getClientBasic() {
		return clientBasic;
	}

	public void setClientBasic(ClientBasic clientBasic) {
		this.clientBasic = clientBasic;
	}
}