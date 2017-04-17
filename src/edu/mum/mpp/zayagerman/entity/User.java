
package edu.mum.mpp.zayagerman.entity;

import java.util.Date;

public class User {
	
    private int id;
    private String loginName;
    private String name;
    private String password;
    private String accessLevel;
    private Date lastVisited;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAccessLevel() {
		return accessLevel;
	}
	
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	public Date getLastVisited() {
		return lastVisited;
	}
	
	public void setLastVisited(Date lastVisited) {
		this.lastVisited = lastVisited;
	}
}