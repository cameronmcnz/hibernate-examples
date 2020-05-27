package com.mcnz.jpa.examples;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Player {
	
	
	public Player() {}
	
	public Player(String name, String password) {
		this.name = name;
		this.password=password;
	}

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String password;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

}
