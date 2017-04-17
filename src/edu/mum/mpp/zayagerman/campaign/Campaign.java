
package edu.mum.mpp.zayagerman.campaign;

import java.time.LocalDate;

public class Campaign {

    public int id;
    public String name;
    public LocalDate date;
    public String details;
    public boolean state;
    
    public Campaign() {
    }
    
	public Campaign(int id, String name, LocalDate date, String details, boolean state) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.details = details;
		this.state = state;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}