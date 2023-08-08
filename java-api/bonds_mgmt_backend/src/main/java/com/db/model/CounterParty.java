/**
 * 
 */
package com.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "counterparty")	
public class CounterParty {
	
	private @Id @GeneratedValue Long id;
	
	@Column(name="name")
	private String name;

}
