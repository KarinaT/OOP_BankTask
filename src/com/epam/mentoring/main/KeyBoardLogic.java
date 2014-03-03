package com.epam.mentoring.main;

import java.io.InputStream;
import java.util.Scanner;

import com.epam.mentoring.interfaces.IBank;
import com.epam.mentoring.interfaces.IBank.IAccount.AccountType;
import com.epam.mentoring.menu.BussinesLogic;

public class KeyBoardLogic {
	
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
			//case "1":  getBank(scan, bussinesLogic); break;
			case "1":  openBankAccount(scan, bussinesLogic);break;
			case "2": getAllAccounts(scan, bussinesLogic);break;
			case "Q": System.out.println("Good bye!");return;
			default: System.out.println("Bad input!");break;
			}
		}
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
	
	private static void printOperations() {
		System.out.println("Please choose operation: ");
	//	System.out.println("Press 1 to get bank");
		System.out.println("Press 1 to open a new account");
		System.out.println("Press 2 to get all accounts");
		System.out.println("Press Q to quite");

	} 
	
	private static void openBankAccount(Scanner scan, BussinesLogic bussinesLogic){
		IBank bank = null;
		String input = null;
		if(bank == null){			
			getBank(scan, bussinesLogic);
			
		}
		printAllAccounts(bussinesLogic);
		input = scan.nextLine();	
		int accountId = Integer.parseInt(input);
		bank = bussinesLogic.getBanks().get(Integer.parseInt(input)-1);
		if(input.equalsIgnoreCase("1")){
			System.out.println("You've chosen " + AccountType.CHECKING);
			System.out.println("Please, put some money: ");
			int money = Integer.parseInt(scan.nextLine());
			System.out.println("You've put " + money);			
			bussinesLogic.openAccount(bank, accountId, AccountType.CHECKING, money);
		} else if(input.equalsIgnoreCase("2")){
			System.out.println("You've chosen " + AccountType.CREDIT);
			System.out.println("Please, put some money: ");
			int money = Integer.parseInt(scan.nextLine());
			System.out.println("You've put " + money);			
			bussinesLogic.openAccount(bank, accountId, AccountType.CREDIT, money);
		}else if(input.equalsIgnoreCase("3")){
			System.out.println("You've chosen " + AccountType.DEPOSIT);
			System.out.println("Please, put some money: ");
			int money = Integer.parseInt(scan.nextLine());
			System.out.println("You've put " + money);			
			bussinesLogic.openAccount(bank, accountId, AccountType.DEPOSIT, money);
		}
	}
	
	private static void printAllAccounts(BussinesLogic bussinesLogic) {
		
		System.out.println("Please, enter 1 to choose " + IBank.IAccount.AccountType.CREDIT + " account type, 2 for " + IBank.IAccount.AccountType.CHECKING + " account type or 3 for " + IBank.IAccount.AccountType.DEPOSIT +  " account type");	 
	}
	
	private static void getAllAccounts(Scanner scan, BussinesLogic bussinesLogic) {

		System.out.println("There are your all bank accounts: ");
		bussinesLogic.getAllBankAccounts();
	}
}
