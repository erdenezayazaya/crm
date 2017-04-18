
package edu.mum.mpp.zayagerman.entity;

import java.sql.Date;

public class Campaign {
    public int id;
    public String name;
    public Date date;
    public String details;
    public int state;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int isState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}