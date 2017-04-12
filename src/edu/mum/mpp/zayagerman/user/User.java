
package edu.mum.mpp.zayagerman.user;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
	
	@Id @GeneratedValue
	@Column(name = "id")
    private int id;

	@Column(name = "loginName")
    private String loginName;

	@Column(name = "name")
    private String name;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "accessLevel")
    private String accessLevel;
	
	@Column(name = "lastVisited")
    private LocalDate lastVisited;
    
    public User() {
    }
    
    public User(String loginName, String name, String password, String accessLevel, LocalDate lastVisited) {
		super();
		this.loginName = loginName;
		this.name = name;
		this.password = password;
		this.accessLevel = accessLevel;
		this.lastVisited = lastVisited;
	}
    
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
	
	public LocalDate getLastVisited() {
		return lastVisited;
	}
	
	public void setLastVisited(LocalDate lastVisited) {
		this.lastVisited = lastVisited;
	}
}