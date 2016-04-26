package com.corejava.concurrency.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {
	private static final Logger log = LoggerFactory.getLogger(Bank.class);
	public static final int ACCOUNT_CAPACITY = 100;

	private static final int INITIAL_BALANCE = 10;

	private int[] accounts = new int[ACCOUNT_CAPACITY];

	private Lock bankLock = new ReentrantLock();
	private Condition sufficientFunds;

	private int initialTotalBalance = 0;

	public int getInitialTotalBalance() {
		return initialTotalBalance;
	}

	public Bank() {
		init();
		sufficientFunds = bankLock.newCondition();
	}

	private void init() {
		for (int i = 0; i < ACCOUNT_CAPACITY; i++) {
			accounts[i] = INITIAL_BALANCE;
		}

		initialTotalBalance = getTotalBalance();
	}

	public void transfer(int fromAccount, int toAccount, int amount) {
		bankLock.lock();
		log.debug(String.format("Transfer: from <%d> to <%d>, amount [%d] - ST", fromAccount, toAccount, amount));
		try {
			while (accounts[fromAccount] < amount) {
				try {
					log.warn(String.format("Account <%d %d> insufficient for amount [%d]", fromAccount,
							accounts[fromAccount], amount));
					sufficientFunds.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			accounts[fromAccount] -= amount;
			accounts[toAccount] += amount;


			log.debug(String.format("Operator:%s - Transfered [%d] from <%d %d> to <%d %d> ",
					Thread.currentThread().getName(), amount, fromAccount, accounts[fromAccount], toAccount,
					accounts[toAccount]));

			log.debug(String.format("Transfer: from <%d> to <%d>, amount [%d] - ED", fromAccount, toAccount, amount));

		} finally {
			sufficientFunds.signalAll();
			bankLock.unlock();
		}
	}

	public int getBalance(int account) {
		return accounts[account];
	}

	public int getTotalBalance() {
		bankLock.lock();
		try {
			int sum = 0;
			List<Integer> accountsAsList = new ArrayList<Integer>();
			for (int account : accounts) {
				accountsAsList.add(account);
			}

			sum = accountsAsList.stream().mapToInt(e -> {
				return e;
			}).sum();

			return sum;
		} finally {
			bankLock.unlock();
		}
	}
}
