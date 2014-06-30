package com.tikal.trades;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.com.tikal.traders.Application;
import com.com.tikal.traders.domain.entity.Transaction;
import com.com.tikal.traders.repository.memory.TransactionMemoryRepository;
import com.com.tikal.traders.service.impl.TradeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TransactionMemoryRepositoryTests {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TransactionMemoryRepositoryTests.class);

	@Autowired
	private TransactionMemoryRepository transactionMemoryRepository;

	@Test
	public void testFindAllTransactions() {
		List<Transaction> transactions = transactionMemoryRepository.findAllTransactions(2011);
		Assert.assertEquals(2,transactions.size());
	}

}
