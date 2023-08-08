package com.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity    
@Table(name="security")
public class Security   
{  
	@Id
	@Column(name="id") 
	private long id;  
  
	@Column(name="issuer") 
	private String Issuer;  
  
	@Column(name="maturity_date")  
	private Date Maturity_Date;  
  
	@Column(name="coupon")  
	private int Coupon; 
	
	@Column(name="type")  
	private String Type; 
	
	@Column(name="face_value")  
	private int Face_Value;
	
	@Column(name="status")
	private String Status;
	
	
	
	public long getId()   
	{  
		return id;  
	}  
	
	public void setId(int id)   
	{  
		this.id = id;  
	}  
	
	public String getIssuer()   
	{  
		return Issuer;  
	}  
	
	public void setIssuer(String name)   
	{  
		this.Issuer = name;  
	}  
	
	public Date getMaturity_Date()   
	{  
		return Maturity_Date;  
	}  
	
	public int getCoupon()   
	{  
		return Coupon;  
	}  
	
	public void setCoupon(int coupon)   
	{  
		this.Coupon = coupon;  
	}  
	
	public String getType()   
	{  
		return Type;  
	}  
	
	public void setType(String type)   
	{  
		this.Type = type;  
	}  
	
	public int getFace_Value()   
	{  
		return Face_Value;  
	}  
	
	public void setFace_Value(int value)   
	{  
		this.Face_Value = value;  
	}  
	
	public String getStatus()   
	{  
	    return Status;  
	}  
	public void setStatus(String value)   
	{  
	    this.Status = value;  
	}  

}  

