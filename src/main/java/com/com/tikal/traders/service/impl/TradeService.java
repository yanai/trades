package com.com.tikal.traders.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.com.tikal.traders.domain.entity.Trader;
import com.com.tikal.traders.domain.entity.Transaction;
import com.com.tikal.traders.repository.jpa.TraderRepository;
import com.com.tikal.traders.repository.jpa.TransactionRepository;
import com.com.tikal.traders.repository.memory.TransactionMemoryRepository;

@RestController
public class TradeService {
	
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TraderRepository traderRepository;
	
	@Autowired
	private TransactionMemoryRepository transactionMemoryRepository; 
	
	//http://localhost:8080/transactions?year=2011
	@RequestMapping("/transactions")
	public List<Transaction> findAllTransactions(@RequestParam(value="year", required=true)int year){
		return transactionRepository.findAllTransactions(year);
	}
	
	//http://localhost:8080/transactions/cities
	@RequestMapping("/transactions/cities")
	public Set<String> findTransactionTradersCities(){
		return traderRepository.findTransactionTradersCities();
	}
	
	
	//http://localhost:8080/transactions/traders?city=Cambridge
	@RequestMapping("/transactions/traders")
	public List<Trader> findAllTradersTradersFrom(@RequestParam(value="city", required=true) String city){
		return traderRepository.findAllTradersTradersFrom(city);
	}
	
	//echo '{"name":"kuku1", "city":"popo"}' | curl -H "Content-Type: application/json"  -u admin:manager -d @- http://localhost:8080/traders
	@RequestMapping(method=RequestMethod.POST,value="/traders")
	public int addTrader(@RequestBody @Valid Trader trader){
		return traderRepository.save(trader).getId();
	}
	
	//http://localhost:8080/traders
	@RequestMapping("/traders")
	public List<Trader> findAllTraders(){
		return traderRepository.findAll();
	}
	
	
	
	@PostConstruct
	private void init(){		
		traderRepository.save(transactionMemoryRepository.getTraders());
		transactionRepository.save(transactionMemoryRepository.getTransactions());
	}

}
