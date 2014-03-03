package com.epam.mentoring.domain;

import java.util.ArrayList;
import java.util.List;

import com.epam.mentoring.interfaces.IBank;
import com.epam.mentoring.util.MoneyException;

public class Bank implements IBank {

	private String bankName;
	private List<IBank.IAccount> accountsList;
	private int accountSize;

	public String getBankName() {
		return bankName;
	}

	public Bank(String bankName, int accountSize) {
		this.bankName = bankName;
		this.accountSize = accountSize;
		accountsList = new ArrayList<>(accountSize);
	}

	public void createAccount(int id, IBank.IAccount.AccountType accountType,
			int money) {
		if (accountsList.size() < accountSize) {
			accountsList.add(new Account(id, accountType, money));
		} else {
			System.out.println("Sorry, but you can't create more than "
					+ this.accountSize + " accounts in the bank! ");
		}
	}

	@Override
	public String getName() {
		return bankName;
	}

	@Override
	public IAccount getAccount(int id) {
		for (IBank.IAccount account : this.accountsList) {
			if (account.getId() == id) {
				return account;
			}
		}
		return null;
	}

	@Override
	public List<IAccount> getAllAccounts() {
		return this.accountsList;
	}

	public class Account implements IAccount {
		private int id;
		private AccountType accountType;
		private int money;

		public Account(int id, AccountType accountType, int money) {
			this.id = id++;
			this.accountType = accountType;
			this.money = money;
		}

		@Override
		public int getId() {
			return this.id;
		}

		@Override
		public AccountType getAccountType() {
			return accountType;
		}

		@Override
		public void deposit(int amount) throws MoneyException {
			if (amount > 0) {
				this.money += amount;

			} else {
				throw new MoneyException(
						"You don't have enough money for deposit! ");
			}
		}

		@Override
		public int withdraw(int amount) throws MoneyException {
			if (amount > 0 && amount < this.money) {
				this.money = this.money - amount;

			} else {
				throw new MoneyException("You've got not enough money! ");
			}
			return this.money;
		}

		@Override
		public int check() {
			return this.money;
		}

		@Override
		public String toString() {
			return "Account in "+getBankName()+" bank[id=" + id + ", accountType=" + accountType
					+ ", money=" + money + "]";
		}
	}
}
