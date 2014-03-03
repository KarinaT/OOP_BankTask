package com.epam.mentoring.main;

import java.io.InputStream;
import java.util.Scanner;

import com.epam.mentoring.domain.Bank.Account;
import com.epam.mentoring.interfaces.IBank;
import com.epam.mentoring.menu.BussinesLogic;

public class Main {

	public static void main(String[] args) {
		start(System.in, new BussinesLogic());
	}

	public static void start(InputStream is, BussinesLogic bussinesLogic) {
		Scanner scan = new Scanner(is);
		String input = null;
		while (true) {
			printOperations();			
			input = scan.nextLine();
			switch (input) {
			case "1": getBank(scan, bussinesLogic); break;
			case "2": openBankAccount(scan, bussinesLogic);break;
			case "3": //getAllAccounts(scan, bussinesLogic);break;
			case "Q": System.out.println("Good bye!");return;
			default: System.out.println("Bad input!");break;
			}
		}
	}
	
	private static void getAllAccounts(Scanner scan, BussinesLogic bussinesLogic) {
		bussinesLogic.getAllBankAccounts();
	}

	private static void openBankAccount(Scanner scan, BussinesLogic bussinesLogic){
		String input = null;
		printAllAccounts(bussinesLogic);
		IBank bank = null;
		while (bank==null) {
			input = scan.nextLine();
			try{
				bank = bussinesLogic.getBanks().get(Integer.parseInt(input)-1);
			}catch(NumberFormatException exception){
				System.out.println("Incorrect input");				
			}
			if(bank!=null){
				System.out.println(bank.getName());
			}else{
				System.out.println("Such name doesn't exist");
			}
		}
		IBank.IAccount account = null;
		if(account == null){
			bank = bussinesLogic.getBanks().get(Integer.parseInt(input)-1);
		}
		printAllAccounts(bussinesLogic);
		input = scan.nextLine();
		bank = bussinesLogic.getBanks().get(Integer.parseInt(input)-1);
		input = scan.nextLine();
		IBank.IAccount.AccountType accountTypes = null;		
		int accountId = Integer.parseInt(input);
		if(input.equalsIgnoreCase("1")){
			System.out.println("You've chosen " + accountTypes.CHECKING);
			System.out.println("Please, put some money: ");
			int money = Integer.parseInt(scan.nextLine());
			System.out.println("You've put " + money);
			
			bussinesLogic.openAccount(bank, accountId, accountTypes.CHECKING, money);
		}
		/*String input = null;
		System.out.println("Please choose an account type ");
		printAllAccounts(bussinesLogic);
		IBank bank = null;
		while (bank==null) {
			input = scan.nextLine();
			try{
				bank = bussinesLogic.getBanks().get(Integer.parseInt(input)-1);
			}catch(NumberFormatException exception){
				System.out.println("Incorrect input");				
			}
			if(bank!=null){
				System.out.println(bank.getName());
			}else{
				System.out.println("Such name doesn't exist");
			}
		}
		/*IAccount accountType = null;
		//IBank bank = getBank(scan, bussinesLogic);
		for(int i =0; i< bussinesLogic.getAllAccounts().size(); i++){
		accountType = bussinesLogic.getAllAccounts().get(i);
		}
		System.out.println("accountType " + accountType);
		
		/*System.out.println("Please choose an account type ");
		printAllAccounts(bussinesLogic);
		//input = scan.nextLine();
		IBank.IAccount account = null;
		while (account ==null) {
			input = scan.nextLine();
			try{
				account = bussinesLogic.getAllAccounts().get(Integer.parseInt(input)-1);
			}catch(NumberFormatException exception){
				System.out.println("Incorrect input");				
			}
			if(account!=null){
				System.out.println("You've chosen " + account.getAccountType());
			}else{
				System.out.println("Such name doesn't exist");
			}
		}
		//printAllAccounts(bussinesLogic);

		System.out.println("How much money do you want to put?");
		int moneyCount = Integer.parseInt(scan.nextLine());
		//openAccount
		
		*/
	}

	private static void getBank(Scanner scan, BussinesLogic bussinesLogic){
		String input = null; 
		printAllBanks(bussinesLogic);
		IBank bank = null;
		while (bank==null) {
			input = scan.nextLine();
			try{
				bank = bussinesLogic.getBanks().get(Integer.parseInt(input)-1);
			}catch(NumberFormatException exception){
				System.out.println("Incorrect input!");				
			}
			if(bank!=null){
				System.out.println("You've chosen " + bank.getName());
			}else{
				System.out.println("Such name doesn't exist!");
			}
		}	
	}
	
	private static void printAllBanks(BussinesLogic bussinesLogic) {
		StringBuilder builder = new StringBuilder();
		builder.append("==== Please, choose a bank.");
		int count = 1;
		for (IBank bank : bussinesLogic.getBanks()) {
			builder.append("Press ").append(count++).append(" for ")
					.append(bank.getName()).append("; ");
		}
		builder.append(" ====");
		System.out.println(builder);
	}
	
	private static void printAllAccounts(BussinesLogic bussinesLogic) {
		
		System.out.println("Please, enter 1 to choose " + IBank.IAccount.AccountType.CREDIT + " 2 for " + IBank.IAccount.AccountType.CHECKING + " 3 " + IBank.IAccount.AccountType.DEPOSIT);	 

	}

	private static void printOperations() {
		System.out.println("Please choose operation: ");
		System.out.println("Press 1 to get bank");
		System.out.println("Press 2 to open new account");
		System.out.println("Press 3 to get all account");
		System.out.println("Press Q to quite");

	} // 
	//
	//
	// public static void chooseBank() {
	//
	// String input = null;
	// Scanner scan = new Scanner(System.in);
	// System.out.println("==== Please, choose a bank. Press 1 for ПриватБанк, 2 for Ощадбанк or 3 for Swiss bank ====");
	// input = scan.nextLine();
	//
	// if(input.equalsIgnoreCase("1")){
	// Bank bank1 = new Bank("ПриватБанк");
	// System.out.println("You've chosen " + bank1.getBankName());
	// }else if(input.equalsIgnoreCase("2")){
	// Bank bank2 = new Bank("Ощадбанк");
	// System.out.println("You've chosen " + bank2.getBankName());
	// }else if(input.equalsIgnoreCase("3")){
	// Bank bank3 = new Bank("Swiss bank");
	// System.out.println("You've chosen " + bank3.getBankName());
	// }
	// }
	//
	// public static boolean openAccount() {
	// boolean status = false;
	// String input;
	//
	// Scanner scan = new Scanner(System.in);
	// System.out.println("\n==== Please, choose a type of account. Press 1 to open Credit Account, 2 to open Checking Account or 3 for Deposit Account ====");
	// input = scan.nextLine();
	//
	// if(input.equalsIgnoreCase("1")){
	// createAccount();
	// System.out.println("You've chosen " + IBank.IAccount.AccountType.CREDIT +
	// " account type");
	// }else if(input.equalsIgnoreCase("2")){
	// System.out.println("You've chosen " + IBank.IAccount.AccountType.CHECKING
	// + " account type");
	// }else if(input.equalsIgnoreCase("3")){
	// System.out.println("You've chosen Deposit Account " +
	// IBank.IAccount.AccountType.DEPOSIT + " account type");
	// }
	//
	// status = true;
	//
	// return status;
	// }
}
