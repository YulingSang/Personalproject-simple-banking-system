
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class SaverAccount extends Account implements Serializable{
	private Calendar noticeDate;
	private double noticeAmount;
	
	public SaverAccount(int accNo, Customer customer) {
		super(accNo, customer);
		this.overDraftLimit = 0;
		this.noticeNeeded = true;
		Calendar calendar = new GregorianCalendar(1000,01,01);
		this.setNotice(calendar, 0);
	}

	public Calendar getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Calendar noticeDate) {
		this.noticeDate = noticeDate;
	}

	public double getNoticeAmount() {
		return noticeAmount;
	}

	public void setNoticeAmount(double noticeAmount) {
		this.noticeAmount = noticeAmount;
	}
	
	public void setNotice(Calendar noticeDate, double noticeAmount) {
		setNoticeDate(noticeDate);
		setNoticeAmount(noticeAmount);
	}

}
