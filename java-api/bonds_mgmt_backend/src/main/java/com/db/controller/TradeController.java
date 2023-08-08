/**
 * 
 */
package com.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Trade;
import com.db.repository.TradeRepository;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/trade")
public class TradeController {
	
	@Autowired 
	private TradeRepository tradeRepository;
	
	public ResponseEntity<Trade> createTrade(Trade trade) {
		Trade newTrade = tradeRepository.save(trade);
		
		return ResponseEntity.ok(newTrade);
    }

	
	@GetMapping("/trade/{id}")
    public ResponseEntity<Trade> getTradeById(long id) {
    	Trade trade = tradeRepository.findById(id).orElse(null);
    	
    	return ResponseEntity.ok(trade);
    }
	

}
