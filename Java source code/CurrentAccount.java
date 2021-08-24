import java.io.Serializable;

public class CurrentAccount extends Account implements Serializable{

	public CurrentAccount(int accNo, Customer customer) {
		super(accNo, customer);
		this.overDraftLimit = 500;
		this.noticeNeeded = false;
	}

}
