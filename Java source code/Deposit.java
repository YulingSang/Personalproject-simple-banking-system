
import java.io.Serializable;
import java.util.Calendar;


public class Deposit extends Transaction implements Serializable{
	private boolean cleared;
	
	public Deposit(double amount, Calendar date) {
		super(amount, date);
	}

	public boolean isCleared() {
		return cleared;
	}

	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

	
}
