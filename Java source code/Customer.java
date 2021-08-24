
import java.util.Calendar;
import java.io.Serializable;
import java.util.*;

public class Customer implements Serializable{
	private String name;
	private String address;
	private Calendar dateOfBirth;
	private boolean creditStatus;
	public ArrayList<Account> accounts;
	
	private int age;
	
	public Customer(String name, String address, Calendar dateOfBirth) {
		this.setName(name);
		this.setAddress(address);
		this.setDateOfBirth(dateOfBirth);
		this.setCreditStatus(false);
		this.accounts = new ArrayList<Account>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(boolean creditStatus) {
		this.creditStatus = creditStatus;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	/*public void addAccount() {
		
	}*/


}
