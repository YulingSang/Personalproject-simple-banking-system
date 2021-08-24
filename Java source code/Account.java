
import java.io.Serializable;
import java.util.Random;

public class Account implements Serializable{
	protected int accNo;
	protected int pin;
	protected Customer customer;
	protected double balance;
	protected double uncreditAmount;
	protected double overDraftLimit;
	protected boolean isSuspended;
	protected boolean isActive;
	protected boolean noticeNeeded;
	
	public Account(int accNo, Customer customer) {
		this.accNo = accNo;
		this.customer = customer;
		this.balance = 0.0;
		this.uncreditAmount=0.0;
		this.isActive = true;
		this.noticeNeeded = false;
		//generateAccNo();
	}

	/*private void generateAccNo() {
		Random r = new Random();
		accNo = (100000 + r.nextInt(900000));
	}*/
	
	
	public int getAccNo() {
		return accNo;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public int getPin() {
		return pin;
	}
	
	public boolean isSuspended() {
		return this.isSuspended;
	}
	
	/*public void addDeposit() {
		
	}*/
	
	public void addBalance(int amount) {
		this.balance = this.balance + amount;
	}
	
	public void subBalance(int amount) {
		if(amount<=this.getBalance()) {
			this.balance = this.balance - amount;
		}else if(amount<=this.getBalance()+this.overDraftLimit){
			this.overDraftLimit = this.overDraftLimit - amount + this.balance;
			this.balance = 0;
		}
	}
	
	public void clearFunds() {
		this.balance = this.balance + this.uncreditAmount;
		this.uncreditAmount = 0.0;
	}
	
	
	public void setSuspended(boolean a) {
		this.isSuspended = a;
	}
	
	public void close() {
		this.isActive = false;
	}
}

