package edu.mum.mpp.zayagerman.entity;

import java.sql.Date;

public class Activity {

    private int id;
    private String type;
    private Date dateBegin;
    private Date dateClosed;
    private int durationHours;
    private String state;
    private ClientBasic clientBasic;

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
	
	public Date getDateBegin() {
		return dateBegin;
	}
	
	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}
	
	public Date getDateClosed() {
		return dateClosed;
	}
	
	public void setDateClosed(Date dateClosed) {
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