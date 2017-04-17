package edu.mum.mpp.zayagerman.contact;

public class Contact {

    private int id;
    private Company company;
    private Industry industry;
    
    public Contact() {
    }
    
	public Contact(int id, Company company, Industry industry) {
		super();
		this.id = id;
		this.company = company;
		this.industry = industry;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Industry getIndustry() {
		return industry;
	}
	
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
}