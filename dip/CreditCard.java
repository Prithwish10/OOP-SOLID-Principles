package dip;

public class CreditCard implements BankCard{

	public void doTransaction(long amount) {
		System.out.println("Do transaction using credit card");
	}
}
