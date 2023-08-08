package com.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Security   
{  
	private @Id @GeneratedValue Long  id;  
  
	private String issuer;  
  
	private Date maturity_date;  
  
	private int coupon; 
	
	private String type; 
	
	private int face_value;
	
	private String status;
	
	
	public String getIssuer() {
		return issuer;
	}
}  

