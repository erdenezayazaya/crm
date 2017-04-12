package edu.mum.mpp.zayagerman.contact;

import javax.persistence.Embeddable;

@Embeddable
public class Company {
	
    public int id;
    public String name;
    public String type;
    
    public Company() {
    }

	public Company(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}