package com.crescendo.app.core.utils;

public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  Account acc = new Account(123456, "Savings", 10000.00);
		  System.out.println(acc.toString());
		 
		 //acc.deposit(1);
		  acc.withdraw(1000);
		 
		 System.out.println(acc.toString());
		 
	}

}
