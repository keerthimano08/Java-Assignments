package org.methodOverride;

public class AxisBank extends BankInfo {

	public static void main(String[] args) {
		AxisBank acct = new AxisBank();
		acct.saving();
		acct.fixed();
		acct.deposit();

	}
	
	public void deposit() {
		System.out.println("deposit amount from Axisbank");
	}


}
