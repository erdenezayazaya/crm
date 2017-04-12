package edu.mum.mpp.zayagerman.contact;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Contact")
public class Contact {

	@Id @GeneratedValue
	@Column(name = "id")
    private int id;
    
    @Embedded
    private Company company;
    
    @Embedded
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