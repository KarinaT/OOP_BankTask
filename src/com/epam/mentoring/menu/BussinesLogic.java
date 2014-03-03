package com.epam.mentoring.menu;

import java.util.ArrayList;
import java.util.List;

import com.epam.mentoring.domain.Bank;
import com.epam.mentoring.interfaces.IBank;

public class BussinesLogic {

	private List<IBank> banks;

	public BussinesLogic() {
		this.banks = new ArrayList<>();
		this.banks.add(new Bank("Bank1"));
		this.banks.add(new Bank("Bank2"));
		this.banks.add(new Bank("Bank3"));
	}

	public IBank getBank(String bankName) {
		for (IBank bank : this.banks) {
			if (bank.getName().equalsIgnoreCase(bankName)) {
				return bank;
			}
		}
		return null;
	}

	public String openAccount(IBank bank, int accountId,IBank.IAccount.AccountType type, int money) {
		bank.createAccount(accountId, type, money);
		return "Success!!";
	}

	public List<IBank.IAccount> getAllBankAccounts() {
		List<IBank.IAccount> result = new ArrayList<>();
		for (IBank bank : this.banks) {
			result.addAll(bank.getAllAccounts());
		}
		return result;
	}

	public List<IBank> getBanks() {
		return banks;
	}	 
}
