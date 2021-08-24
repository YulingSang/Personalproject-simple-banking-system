
import java.io.Serializable;
import java.util.Calendar;


public class Withdrawal extends Transaction implements Serializable{
	
	public Withdrawal(double amount, Calendar date) {
		super(amount, date);
	}

	private boolean cleared;
	
	

	public boolean isCleared() {
		return cleared;
	}

	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

	
}
