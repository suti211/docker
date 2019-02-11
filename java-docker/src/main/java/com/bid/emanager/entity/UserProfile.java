package com.bid.emanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserProfile {
	
	@Id
	@Column(name="id")
	private int id;
	
	
}
