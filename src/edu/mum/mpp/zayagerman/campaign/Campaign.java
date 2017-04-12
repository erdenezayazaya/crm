
package edu.mum.mpp.zayagerman.campaign;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="Campaign")
public class Campaign {

	@Id @GeneratedValue
	@Column(name = "id")
    public int id;
	
	@Column(name = "name")
    public String name;
	
	@Column(name = "date")
    public LocalDate date;
	
	@Column(name = "details")
    public String details;
	
	@Column(name = "state")
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