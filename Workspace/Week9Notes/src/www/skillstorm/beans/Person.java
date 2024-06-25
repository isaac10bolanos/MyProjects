package www.skillstorm.beans;

public class Person {
	
	private BankAccount account;
	private BankAccount2 account2; // will do the same thing with slightly differences
	private String name;
	
	public Person(String name, BankAccount account) {
		this.account = account;
		this.name = name;
	}
	
	public Person(String name, BankAccount2 account2) {
		this.account2 = account2;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void add(double amount) {
		// don't need to synchronize this because the method already does that
		double newBalance = this.account.addMoney(amount);
		System.out.println(this.name + " deposited " + amount + 
				", the new balance is " + newBalance);
	}
	
	public void withdraw(double amount) {
		// don't need to synchronize this because the method already does that
		double newBalance = this.account.withdrawMoney(amount);
		System.out.println(this.name + " withdrew " + amount +
				", the new balance is " + newBalance);
	}
	
	// these use BankAcount2
	public void add2(double amount) {
		double newBalance = this.account2.addMoney(amount);
		System.out.println(this.name + " deposited " + amount + ", the new balance is " + newBalance);
	}
	
	public void withdraw2(double amount) {
		double newBalance = this.account2.withdrawMoney(amount);
		System.out.println(this.name + " withdrew " + amount + ", the new balance is " + newBalance);
	}
	
	
}
