import java.io.Serializable;

public class JuniorAccount extends Account implements Serializable{

	public JuniorAccount(int accNo, Customer customer) {
		super(accNo, customer);
		this.overDraftLimit = 0;
		this.noticeNeeded = false;
	}

}
