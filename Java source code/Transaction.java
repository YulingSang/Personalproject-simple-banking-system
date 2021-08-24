
import java.io.Serializable;
import java.util.Calendar;

public class Transaction implements Serializable{
	private double amount;
	private Calendar date;
	private Calendar time;
	private Account account;
	
	public Transaction(double amount, Calendar date) {
		this.setAmount(amount);
		this.setDate(date);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
