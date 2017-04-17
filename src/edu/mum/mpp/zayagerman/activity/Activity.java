package edu.mum.mpp.zayagerman.activity;

import java.time.LocalDate;

import javax.persistence.*;

import edu.mum.mpp.zayagerman.client.ClientBasic;

public class Activity {

    private int id;
    private String type;
    private LocalDate dateBegin;
    private LocalDate dateClosed;
    private int durationHours;
    private String state;
    private ClientBasic clientBasic;
    
    public Activity() {
    }
    
	public Activity(int id, String type, LocalDate dateBegin, LocalDate dateClosed, int durationHours, String state,
			ClientBasic clientBasic) {
		super();
		this.id = id;
		this.type = type;
		this.dateBegin = dateBegin;
		this.dateClosed = dateClosed;
		this.durationHours = durationHours;
		this.state = state;
		this.clientBasic = clientBasic;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public LocalDate getDateBegin() {
		return dateBegin;
	}
	
	public void setDateBegin(LocalDate dateBegin) {
		this.dateBegin = dateBegin;
	}
	
	public LocalDate getDateClosed() {
		return dateClosed;
	}
	
	public void setDateClosed(LocalDate dateClosed) {
		this.dateClosed = dateClosed;
	}
	
	public int getDurationHours() {
		return durationHours;
	}
	
	public void setDurationHours(int durationHours) {
		this.durationHours = durationHours;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	public ClientBasic getClientBasic() {
		return clientBasic;
	}

	public void setClientBasic(ClientBasic clientBasic) {
		this.clientBasic = clientBasic;
	}
}