package com.crescendo.app.core.components;

public class FactorialProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fact = 1;
		
		for(int i = 10; i >=1; i--) {
			fact = fact * i;
		}
		System.out.println("factial of 10 is :: " + fact);
	}

}
