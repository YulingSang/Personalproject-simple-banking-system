import javax.swing.*;
import java.awt.*;

public class BankUI{
	
	public JFrame mainUI;
	public JLabel label1; //Welcome to the bank system
	public JLabel label2; //please choose the role you are
	public JButton button1; //Customer
	public JButton button2; //Employee
	public JButton button3; //ECS
	public JPanel panel1,panel2,panel3,panel4,panel5;

	public JFrame employeeUI;
	public JLabel label3; //Employee Interface
	public JButton button4; //Open Account
	public JButton button5; //Suspend Account
	public JButton button6; //close Account
	public JButton button7; //Back
	public JPanel panel6,panel7,panel8,panel9,panel10;
	
	public JFrame createAccUI;
	public JLabel label4;//choose whether the customer has been registered
	public JButton button8;//current customer
	public JButton button9;//new customer
	public JPanel panel11,panel12,panel13;
	
	public JFrame currentCustomerUI;
	public JLabel label5;//Please enter the name of customer
	public JTextField text1;//name of customer
	public JButton button10;//Check
	public JButton button11;//Back
	public JPanel panel14,panel15,panel16;
	
	public JFrame confirmCreditUI;
	public JLabel label6;// the credit agency will confirm the status of customer
	public JButton button12;//Confirm
	public JButton button13;//Not Confirm
	public JPanel panel17,panel18;
	
	public JFrame chooseAccUI;
	public JLabel label7;//Please choose the right account the customer want to open
	public JButton button14;//Saver Account
	public JButton button15;//Junior Account
	public JButton button16;//Current Account
	public JButton button17;//Cancel Deal
	public JPanel panel19,panel20,panel21,panel22,panel23;
	
	public JFrame enterPinUI;
	public JLabel label8;//The account number is: 
	public JLabel label9;//the generated accNo.
	public JLabel label10;//Please enter the PIN:
	public JTextField text2;//PIN the customer want to set
	public JButton button18;//Confirm
	public JPanel panel24,panel25,panel26;
	
	public JFrame addCustomerUI;
	public JLabel label11;//Please enter the name
	public JTextField text3;//name
	public JLabel label12;//Please enter the address
	public JTextField text4;//address
	public JLabel label13;//Please enter the date of birth
	public JTextField text5;//date of birth
	public JButton button19;//confirm
	public JButton button20;//Cancel creation
	public JPanel panel27,panel28,panel29,panel30;
	
	public JFrame suspendAccUI;
	public JLabel label14;//Please enter the number of accNo. to suspend
	public JTextField text6;//accNo
	public JButton button21;//Confirm
	public JButton button22;//Cancel Suspend
	public JPanel panel31,panel32;
	
	public JFrame cancelAccUI;
	public JLabel label15;//Please enter the number of accNo. to cancel
	public JTextField text7;//accNo
	public JLabel label16;//Once check that the balance is zero, cancellation can be done.
	public JButton button23;//Check
	public JButton button24;//Cancel Close
	public JPanel panel33,panel34,panel35;
	
	public JFrame customerUI;
	public JLabel label17;//Please choose the type of transaction
	public JButton button25;//Deposit
	public JButton button26;//Withdraw
	public JButton button37;//Check Balance
	public JButton button27;//Back
	public JPanel panel36,panel37,panel58,panel38,panel39;
	
	public JFrame depositUI;
	public JLabel label18;//Please enter the account number you want to deposit in
	public JTextField text8;//accNo
	public JLabel label19;//Please enter the amount you want to deposit 
	public JTextField text9;//amount
	public JButton button28;//Confirm
	public JButton button29;//Cancel
	public JRadioButton radio1,radio2; //cash or cheque
	public ButtonGroup bg1;//radio1 radio2
	public JPanel panel40,panel41,panel42,panel47;
	
	public JFrame withdrawUI;
	public JLabel label20;//Please enter the account number you want to withdraw from
	public JTextField text10;//accNo
	public JLabel label21;//Please enter the pin of this account
	public JTextField text11;//pin
	public JLabel label22;//Please enter the amount you want to withdraw
	public JTextField text12;//amount
	public JButton button30;//Confirm
	public JButton button31;//Cancel
	public JPanel panel43,panel44,panel45,panel46;
	
	public JFrame checkBalanceUI;
	public JLabel label23;//Please enter the account number;
	public JTextField text13;//accNo
	public JLabel label24;//Please enter the pin;
	public JTextField text14;//pin
	public JButton button32;//Confirm
	public JButton button33;//Back
	public JPanel panel48,panel49,panel50;
	
	public JFrame balanceUI;
	public JLabel label25;//The balance of the account is:
	public JLabel label26;//The uncreditamount of the account is:
	public JLabel label27;//The overdraftlimit is: 
	public JButton button34;//Back
	public JPanel panel51,panel52,panel53,panel54;
	
	public JFrame setNoticeUI;
	public JLabel label28;//set the notice date
	public JTextField text15;//notice date
	public JLabel label29;//set the notice amount
	public JTextField text16;//notice amount
	public JButton button35;//Confirm
	public JButton button36;//Back
	public JPanel panel55,panel56,panel57;
	
	public BankUI() {
		MainUI();
		EmployeeUI();
		CreateAccUI();
		currentCustomerUI();
		confirmCreditUI();
		chooseAccUI();
		enterPinUI();
		addCustomerUI();
		suspendAccUI();
		cancelAccUI();
		customerUI();
		depositUI();
		withdrawUI();
		checkBalanceUI();
		balanceUI();
		setNoticeUI();
	}
	
	public void MainUI() {
		//mainUI
		mainUI = new JFrame("Main Interface");
		label1 = new JLabel("Welcome to the Bank System!");
		label2 = new JLabel("Please choose the role you are");
		button1 = new JButton("            Employee            ");
		button2 = new JButton("            Customer            ");
		button3 = new JButton("External Clearing System");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel1.add(label1);
		panel2.add(label2);
		panel3.add(button1);
		panel4.add(button2);
		panel5.add(button3);
		mainUI.add(panel1);
		mainUI.add(panel2);
		mainUI.add(panel3);
		mainUI.add(panel4);
		mainUI.add(panel5);
		mainUI.setLayout(new GridLayout(5,1));
		mainUI.setSize(600,400);
		mainUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainUI.setVisible(true);
	}
	public void EmployeeUI() {
		employeeUI = new JFrame("Employee");
		label3 = new JLabel("Please click the function you want to choose");
		button4 = new JButton("  Open an Account  ");
		button5 = new JButton("Suspend an Account");
		button6 = new JButton("  Close an Account  ");
		button7 = new JButton("Back");
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();
		panel10 = new JPanel();
		panel6.add(label3);
		panel7.add(button4);
		panel8.add(button5);
		panel9.add(button6);
		panel10.add(button7);
		employeeUI.add(panel6);
		employeeUI.add(panel7);
		employeeUI.add(panel8);
		employeeUI.add(panel9);
		employeeUI.add(panel10);
		employeeUI.setLayout(new GridLayout(5,1));
		employeeUI.setSize(600,400); 
		employeeUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		employeeUI.setVisible(false);
		
	}
	public void CreateAccUI() {
		createAccUI = new JFrame();
		label4 = new JLabel("Please choose whether the customer has been registered");
		button8 = new JButton("Current Customer");
		button9 = new JButton("   New Customer   ");
		panel11 = new JPanel();
		panel12 = new JPanel();
		panel13 = new JPanel();
		panel11.add(label4);
		panel12.add(button8);
		panel13.add(button9);
		createAccUI.add(panel11);
		createAccUI.add(panel12);
		createAccUI.add(panel13);
		createAccUI.setLayout(new GridLayout(3,1));
		createAccUI.setSize(600,400); 
		createAccUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		createAccUI.setVisible(false);
		
	}
	public void currentCustomerUI() {
		currentCustomerUI = new JFrame();
		label5 = new JLabel("Please enter the name of customer");
		text1 = new JTextField(20);
		button10 = new JButton("  Check  ");
		button11 = new JButton("  Back  ");
		panel14 = new JPanel();
		panel15 = new JPanel();
		panel16 = new JPanel();
		panel14.add(label5);
		panel15.add(text1);
		panel16.add(button10);
		panel16.add(button11);
		currentCustomerUI.add(panel14);
		currentCustomerUI.add(panel15);
		currentCustomerUI.add(panel16);
		currentCustomerUI.setLayout(new GridLayout(3,1));
		currentCustomerUI.setSize(600,400); 
		currentCustomerUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		currentCustomerUI.setVisible(false);
		
	}
	public void confirmCreditUI() {
		confirmCreditUI = new JFrame();
		label6 = new JLabel("Credit agency will check the status of customer");
		button12 = new JButton("  Confirm  ");
		button13 = new JButton("Not Confirm");
		panel17 = new JPanel();
		panel18 = new JPanel();
		panel17.add(label6);
		panel18.add(button12);
		panel18.add(button13);
		confirmCreditUI.add(panel17);
		confirmCreditUI.add(panel18);
		confirmCreditUI.setLayout(new GridLayout(2,1));
		confirmCreditUI.setSize(600,400); 
		confirmCreditUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		confirmCreditUI.setVisible(false);
	}
	public void chooseAccUI() {
		chooseAccUI = new JFrame();
		label7 = new JLabel("Please choose the right account the customer want to open"); 
		button14 = new JButton(" Saver Account ");
		button15 = new JButton(" Junior Account ");
		button16 = new JButton("Current Account");
		button17 = new JButton("    Cancel Deal    ");
		panel19 = new JPanel();
		panel20 = new JPanel();
		panel21 = new JPanel();
		panel22 = new JPanel();
		panel23 = new JPanel();
		panel19.add(label7);
		panel20.add(button14);
		panel21.add(button15);
		panel22.add(button16);
		panel23.add(button17);
		chooseAccUI.add(panel19);
		chooseAccUI.add(panel20);
		chooseAccUI.add(panel21);
		chooseAccUI.add(panel22);
		chooseAccUI.add(panel23);
		chooseAccUI.setLayout(new GridLayout(5,1));
		chooseAccUI.setSize(600,400); 
		chooseAccUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		chooseAccUI.setVisible(false);
		
	}
	public void enterPinUI() {
		enterPinUI = new JFrame();
		label8 = new JLabel("The account number is: ");
		label9 = new JLabel();
		label10 = new JLabel("Please enter the PIN:     ");
		text2 = new JTextField(6);
		button18 = new JButton("    Confirm    ");
		panel24 = new JPanel();
		panel25 = new JPanel();
		panel26 = new JPanel();
		panel24.add(label8);
		panel24.add(label9);
		panel25.add(label10);
		panel25.add(text2);
		panel26.add(button18);
		enterPinUI.add(panel24);
		enterPinUI.add(panel25);
		enterPinUI.add(panel26);
		enterPinUI.setLayout(new GridLayout(3,1));
		enterPinUI.setSize(600,400); 
		enterPinUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		enterPinUI.setVisible(false);
		
	}
	public void addCustomerUI() {
		addCustomerUI = new JFrame();
		label11 = new JLabel("Please enter the name:      ");
		text3 = new JTextField(20);
		label12 = new JLabel("Please enter the address:    ");
		text4 = new JTextField(20);
		label13 = new JLabel("Please enter the date of birth(e.g. 19980101):      ");
		text5 = new JTextField(8);
		button19 = new JButton("    Confirm    ");
		button20 = new JButton(" Cancel Creation ");
		panel27 = new JPanel();
		panel28 = new JPanel();
		panel29 = new JPanel();
		panel30 = new JPanel();
		panel27.add(label11);
		panel27.add(text3);
		panel28.add(label12);
		panel28.add(text4);
		panel29.add(label13);
		panel29.add(text5);
		panel30.add(button19);
		panel30.add(button20);
		addCustomerUI.add(panel27);
		addCustomerUI.add(panel28);
		addCustomerUI.add(panel29);
		addCustomerUI.add(panel30);
		addCustomerUI.setLayout(new GridLayout(4,1));
		addCustomerUI.setSize(600,400); 
		addCustomerUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		addCustomerUI.setVisible(false);
	}
	public void suspendAccUI() {
		suspendAccUI = new JFrame("Suspend Account");
		label14 = new JLabel("Please enter the number of accNo:    ");
		text6 = new JTextField(6);
		button21 = new JButton("    Suspend    ");
		button22 = new JButton("  Reinitiate  ");
		panel31 = new JPanel();
		panel32 = new JPanel();
		panel31.add(label14);
		panel31.add(text6);
		panel32.add(button21);
		panel32.add(button22);
		suspendAccUI.add(panel31);
		suspendAccUI.add(panel32);
		suspendAccUI.setLayout(new GridLayout(2,1));
		suspendAccUI.setSize(600,400); 
		suspendAccUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		suspendAccUI.setVisible(false);		
	}
	public void cancelAccUI() {
		cancelAccUI = new JFrame();
		label15 = new JLabel("Please enter the number of accNo:    ");
		text7 = new JTextField(6);
		label16 = new JLabel("Once check that the balance is zero, close can be done.");
		button23 = new JButton("Check");
		button24 = new JButton("Cancel Close");
		panel33 = new JPanel();
		panel34 = new JPanel();
		panel35 = new JPanel();
		panel33.add(label15);
		panel33.add(text7);
		panel34.add(label16);
		panel35.add(button23);
		panel35.add(button24);
		cancelAccUI.add(panel33);
		cancelAccUI.add(panel34);
		cancelAccUI.add(panel35);
		cancelAccUI.setLayout(new GridLayout(3,1));
		cancelAccUI.setSize(600,400); 
		cancelAccUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		cancelAccUI.setVisible(false);	
	}
	public void customerUI() {
		customerUI = new JFrame("Customer");
		label17 = new JLabel("Please choose the type of transaction");
		button25 = new JButton("      Deposit      ");
		button26 = new JButton("     Withdraw     ");
		button37 = new JButton(" Check Balance ");
		button27 = new JButton("Back");
		panel36 = new JPanel();
		panel37 = new JPanel();
		panel38 = new JPanel();
		panel58 = new JPanel();
		panel39 = new JPanel();
		panel36.add(label17);
		panel37.add(button25);
		panel38.add(button26);
		panel58.add(button37);
		panel39.add(button27);
		customerUI.add(panel36);
		customerUI.add(panel37);
		customerUI.add(panel38);
		customerUI.add(panel58);
		customerUI.add(panel39);
		customerUI.setLayout(new GridLayout(5,1));
		customerUI.setSize(600,400); 
		customerUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		customerUI.setVisible(false);	
	}
	public void depositUI() {
		depositUI = new JFrame("Deposit");
		label18 = new JLabel("Please enter the account number you want to deposit in:   ");
		text8 = new JTextField(6);
		label19 = new JLabel("Please enter the amount you want to deposit:   ");
		text9 = new JTextField(6);
		button28 = new JButton("    Confirm    ");
		button29 = new JButton("    Cancel    ");
		radio1=new JRadioButton("Cash"); 
		radio2=new JRadioButton("Cheque"); 
		bg1=new ButtonGroup(); 
		bg1.add(radio1); 
		bg1.add(radio2);
		radio1.setSelected(true);
		panel40 = new JPanel();
		panel41 = new JPanel();
		panel42 = new JPanel();
		panel47 = new JPanel();
		panel40.add(label18);
		panel40.add(text8);
		panel41.add(label19);
		panel41.add(text9);
		panel47.add(radio1);
		panel47.add(radio2);
		panel42.add(button28);
		panel42.add(button29);
		depositUI.add(panel40);
		depositUI.add(panel41);
		depositUI.add(panel47);
		depositUI.add(panel42);
		depositUI.setLayout(new GridLayout(4,1));
		depositUI.setSize(600,400); 
		depositUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		depositUI.setVisible(false);
	}
	public void withdrawUI() {
		withdrawUI = new JFrame();
		label20 = new JLabel("Please enter the account number you want to withdraw from:   ");
		text10 = new JTextField(6);
		label21 = new JLabel("Please enter the pin of this account:        ");
		text11 = new JTextField(6);
		label22 = new JLabel("Please enter the amount you want to withdraw:    ");
		text12 = new JTextField(6);
		button30 = new JButton("    Confirm    ");
		button31 = new JButton("    Cancel    ");
		panel43 = new JPanel();
		panel44 = new JPanel();
		panel45 = new JPanel();
		panel46 = new JPanel();
		panel43.add(label20);
		panel43.add(text10);
		panel44.add(label21);
		panel44.add(text11);
		panel45.add(label22);
		panel45.add(text12);
		panel46.add(button30);
		panel46.add(button31);
		withdrawUI.add(panel43);
		withdrawUI.add(panel44);
		withdrawUI.add(panel45);
		withdrawUI.add(panel46);
		withdrawUI.setLayout(new GridLayout(4,1));
		withdrawUI.setSize(600,400); 
		withdrawUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		withdrawUI.setVisible(false);
	}
	public void checkBalanceUI() {
		checkBalanceUI = new JFrame("Check Balance");
		label23 = new JLabel("Please enter the account number:    ");
		text13 = new JTextField(6);
		label24 = new JLabel("Please enter the pin of the account:    ");
		text14 = new JTextField(6);
		button32 = new JButton("    Confirm    ");
		button33= new JButton("    Back    ");
		panel48 = new JPanel();
		panel49 = new JPanel();
		panel50 = new JPanel();
		panel48.add(label23);
		panel48.add(text13);
		panel49.add(label24);
		panel49.add(text14);
		panel50.add(button32);
		panel50.add(button33);
		checkBalanceUI.add(panel48);
		checkBalanceUI.add(panel49);
		checkBalanceUI.add(panel50);
		checkBalanceUI.setLayout(new GridLayout(3,1));
		checkBalanceUI.setSize(600,400); 
		checkBalanceUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		checkBalanceUI.setVisible(false);
	}
	public void balanceUI() {
		balanceUI = new JFrame("Balance");
		label25 = new JLabel("The balance of this account:   ");
		label26 = new JLabel("The notcredit amount:    ");
		label27 = new JLabel("The overdraft limit:    ");
		button34= new JButton("Back");
		panel51 = new JPanel();
		panel52 = new JPanel();
		panel53 = new JPanel();
		panel54 = new JPanel();
		panel51.add(label25);
		panel52.add(label26);
		panel53.add(label27);
		panel54.add(button34);
		balanceUI.add(panel51);
		balanceUI.add(panel52);
		balanceUI.add(panel53);
		balanceUI.add(panel54);
		balanceUI.setLayout(new GridLayout(4,1));
		balanceUI.setSize(600,400); 
		balanceUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		balanceUI.setVisible(false);
	}
	public void setNoticeUI() {
		setNoticeUI = new JFrame("Set Notice");
		label28 = new JLabel("Please enter the notice date e.g.20190530:   ");
		text15 = new JTextField(8);
		label29 = new JLabel("Please enter the notice amount:   ");
		text16 = new JTextField(6);
		button35 = new JButton("Confirm");
		button36 = new JButton("Back");
		panel55 = new JPanel();
		panel56 = new JPanel();
		panel57 = new JPanel();
		panel55.add(label28);
		panel55.add(text15);
		panel56.add(label29);
		panel56.add(text16);
		panel57.add(button35);
		panel57.add(button36);
		setNoticeUI.add(panel55);
		setNoticeUI.add(panel56);
		setNoticeUI.add(panel57);
		setNoticeUI.setLayout(new GridLayout(3,1));
		setNoticeUI.setSize(600,400); 
		setNoticeUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setNoticeUI.setVisible(false);
	}
}
