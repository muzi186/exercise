package com.corejava.concurrency.lock;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankOperation {
	static final int MAX_AMOUNT_OPERATOR = 30;

	private Bank bank = new Bank();
	
	private static final Logger log = LoggerFactory.getLogger(BankOperation.class);

	public void start() {
		Runnable operator = () -> {
			while (true) {
				Random r = new Random();
				int fromAcct = r.nextInt(100);
				int toAcct = r.nextInt(100);

				int amount = r.nextInt(1000);

				bank.transfer(fromAcct, toAcct, amount);
			}
		};

		Runnable auditor = () -> {
			while (true) {
				int balance = bank.getTotalBalance();
				
				log.info(String.format("%d  --  %s ", balance, new Date().toString()));
				
				if (balance != bank.getInitialTotalBalance()) {
					log.error(String.format("Bankrupt due to balance is wrong <%d>.", balance));
					System.exit(-1);
				}
				try {
					Thread.sleep(1000*10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		new Thread(auditor).start();

		for (int i = 0; i < MAX_AMOUNT_OPERATOR; i++) {
			new Thread(operator).start();
		}
	}

	public static void main(String[] args) {
		BankOperation bankOperation = new BankOperation();
		bankOperation.start();
	}

}
