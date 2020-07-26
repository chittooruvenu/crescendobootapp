package com.crescendo.app.core.utils;

public class Account {

	private long accountNumber;
	private String accountType;
	private double accountBalance = 0;

	public void withdraw(double amount) {
		if(amount > 0) {
			if(accountBalance - amount >= 0) {
				accountBalance = accountBalance - amount;
			} else { 
				System.out.println("Please maintain sufficient balance");
			}
		} else {
			System.out.println("deposit amount should be greater than ZERO");
		}
		
	}

	public void deposit(double amount) {
		if(amount > 0) {
			accountBalance += amount;
		} else {
			System.out.println("deposit amount should be greater than ZERO");
		}
		
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public Account(int accountNumber, String accountType, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + "]";
	}

}
