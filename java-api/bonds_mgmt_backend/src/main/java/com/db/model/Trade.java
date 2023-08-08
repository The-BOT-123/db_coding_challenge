/**
 * 
 */
package com.db.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "trade")	
public class Trade {
	
	private enum Status{
		SUCCESS, PENDING, FAILED;
	}
	
	private enum TradeType{
		BUY, SELL;
	}

	private @Id @GeneratedValue Long id;
	@Id
	
	@JoinColumn(name="book_id")
	@OneToOne(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Book book;
	
	@JoinColumn(name="counter_party_id")
	@OneToOne(mappedBy = "counterparty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CounterParty counterParty;
	
	@JoinColumn(name="security_id")
	@OneToOne(mappedBy = "security", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Security security;
	
	@Column(name="Quantity")
	private int quantity;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="Status")
	private Status status;
	
	@Column(name="Price")
	private int price;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="trade_type")
	private TradeType trade_type;
	
	@Column(name="trade_date")  
	private Date trade_date;  
	
	@Column(name="settlement_date")  
	private Date settlement_date;  
}
