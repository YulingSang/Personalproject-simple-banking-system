import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;



public class BankControl {
	
	/**set an arraylist to store the customers from the .txt file*/
	public ArrayList<Customer> customers; 
	/**set an arraylist to store the deposits from file*/
	public ArrayList<Deposit> deposits;
	/**set an arraylist to store the withdraws from file*/
	public ArrayList<Withdrawal> withdrawals;
	/**set an arraylist to store the accounts from file*/
	public ArrayList<Account> accounts;
	/**create the bankui*/
	public BankUI ui;
	
	/**create a customer to store the login customer*/
	public Customer customerInUse;
	/**create an account to store the login account*/
	public Account accountInUse;
	/**specialize an saver account to address saver account*/
	public SaverAccount acc1;
	/**create an integer to choose the corresponding account type*/
	public int chosenAcc = 0;//1 for Saver; 2 for Junior; 3 for Current
	/**create an integer to store the generated account number*/
	public int accNumber;
	
	/**
	 * The Constructor will create the local variables and add ActionListener to each button in GUI
	 */
	public BankControl() {
		/**create the local variables*/
		customers = new ArrayList<Customer>();
		deposits = new ArrayList<Deposit>();
		withdrawals = new ArrayList<Withdrawal>();
		accounts = new ArrayList<Account>();
		
		/**create the user interface*/
		ui = new BankUI();
		
		/**add actionlistener to each button in the ui*/
		/**mainUI*/
		ui.button1.addActionListener(new employeeListener());
		ui.button2.addActionListener(new customerListener());
		ui.button3.addActionListener(new externalListener());
		/**employeeUI*/
		ui.button4.addActionListener(new openAccListener());
		ui.button5.addActionListener(new suspendAccListener());
		ui.button6.addActionListener(new closeAccListener());
		ui.button7.addActionListener(new employeeBackListener());
		/**createAccUI*/
		ui.button8.addActionListener(new currentListener());
		ui.button9.addActionListener(new newListener());
		/**currentCustomerUI*/
		ui.button10.addActionListener(new currentCheckListener());
		ui.button11.addActionListener(new currentBackListener());
		/**confirmCreditUI*/
		ui.button12.addActionListener(new confirmCreditListener());
		ui.button13.addActionListener(new notConfirmCreditListener());
		/**chooseAccUI*/
		ui.button14.addActionListener(new saverAccListener());
		ui.button15.addActionListener(new juniorAccListener());
		ui.button16.addActionListener(new currentAccListener());
		ui.button17.addActionListener(new chooseAccBackListener());
		/**enterPinUI*/
		ui.button18.addActionListener(new confirmPinUIListener());
		ui.text2.addKeyListener(new numKeyListener());
		/**addCustomerUI*/
		ui.button19.addActionListener(new addCustomerConfirmListener());
		ui.button20.addActionListener(new addCustomerCancelListener());
		ui.text5.addKeyListener(new numKeyListener());
		/**suspendAccUI*/
		ui.button21.addActionListener(new suspendListener());
		ui.button22.addActionListener(new reinitiateListener());
		/**cancelAccUI*/
		ui.button23.addActionListener(new closeListener());
		ui.button24.addActionListener(new cancelAccBackListener());
		/**customerUI*/
		ui.button25.addActionListener(new depositListener());
		ui.button26.addActionListener(new withdrawListener());
		ui.button37.addActionListener(new checkBalanceListener());
		ui.button27.addActionListener(new customerBackListener());
		/**depositUI*/
		ui.button28.addActionListener(new depositConfirmListener());
		ui.text8.addKeyListener(new numKeyListener());
		ui.button29.addActionListener(new depositCancelListener());
		ui.text9.addKeyListener(new numKeyListener());
		/**withdrawUI*/
		ui.button30.addActionListener(new withdrawConfirmListener());
		ui.button31.addActionListener(new withdrawCancelListener());
		/**checkBalanceUI*/
		ui.button32.addActionListener(new checkBalanceConfirmListener());
		ui.button33.addActionListener(new checkBalanceBackListener());
		/**balanceUI*/
		ui.button34.addActionListener(new balanceBackListener());
		/**setNoticeUI*/
		ui.button35.addActionListener(new setNoticeConfirmListener());
		ui.button36.addActionListener(new setNoticeBackListener());
		
		
	}
	/**get customers from customer.txt file*/
	public ArrayList<Customer> getCustomerFromFile() {
		ArrayList<Customer> temp=null;
	    File file =new File("customer.txt");
	    FileInputStream in;
	    try {
	        in = new FileInputStream(file);
	        ObjectInputStream objIn=new ObjectInputStream(in);
	        temp=(ArrayList<Customer>)objIn.readObject();
	        objIn.close();
	        System.out.println("read customer success!");
	    } catch (IOException e) {
	        System.out.println("read customer failed");
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return temp;	
	}
	
	/**write customers into customer.txt file*/
	public void writeCustomerToFile(ArrayList<Customer> customers) {
		 File file =new File("customer.txt");
	     FileOutputStream out;
	        try {
	            out = new FileOutputStream(file);
	            ObjectOutputStream objOut=new ObjectOutputStream(out);
	            objOut.writeObject(customers);
	            objOut.flush();
	            objOut.close();
	            System.out.println("write customer success!");
	        } catch (IOException e) {
	            System.out.println("write customer failed");
	            e.printStackTrace();
	        }
	}
	
	/**clear the customer.txt*/
	public void clearCustomerFile() {
		File file =new File("customer.txt");
		try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("clear customer success");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**get deposits from deposit.txt file*/
	public ArrayList<Deposit> getDepositFromFile() {
		ArrayList<Deposit> temp=null;
	    File file =new File("deposit.txt");
	    FileInputStream in;
	    try {
	        in = new FileInputStream(file);
	        ObjectInputStream objIn=new ObjectInputStream(in);
	        temp=(ArrayList<Deposit>)objIn.readObject();
	        objIn.close();
	        System.out.println("read deposit success!");
	    } catch (IOException e) {
	        System.out.println("read deposit failed");
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return temp;	
	}
	
	/**write deposits to deposit.txt file*/
	public void writeDepositToFile(ArrayList<Deposit> deposits) {
		 File file =new File("deposit.txt");
	     FileOutputStream out;
	        try {
	            out = new FileOutputStream(file);
	            ObjectOutputStream objOut=new ObjectOutputStream(out);
	            objOut.writeObject(deposits);
	            objOut.flush();
	            objOut.close();
	            System.out.println("write deposits success!");
	        } catch (IOException e) {
	            System.out.println("write deposits failed");
	            e.printStackTrace();
	        }
	}
	
	/**clear the deposit.txt*/
	public void clearDepositFile() {
		File file =new File("deposit.txt");
		try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("clear deposits success");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**get withdrawals from withdrawal.txt file*/
	public ArrayList<Withdrawal> getWithdrawalFromFile() {
		ArrayList<Withdrawal> temp=null;
	    File file =new File("withdrawal.txt");
	    FileInputStream in;
	    try {
	        in = new FileInputStream(file);
	        ObjectInputStream objIn=new ObjectInputStream(in);
	        temp=(ArrayList<Withdrawal>)objIn.readObject();
	        objIn.close();
	        System.out.println("read withdrawal success!");
	    } catch (IOException e) {
	        System.out.println("read withdrawal failed");
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return temp;	
	}
	
	/**write withdrawals to withdrawal.txt file*/
	public void writeWithdrawalToFile(ArrayList<Withdrawal> withdrawals) {
		 File file =new File("withdrawal.txt");
	     FileOutputStream out;
	        try {
	            out = new FileOutputStream(file);
	            ObjectOutputStream objOut=new ObjectOutputStream(out);
	            objOut.writeObject(withdrawals);
	            objOut.flush();
	            objOut.close();
	            System.out.println("write withdrawal success!");
	        } catch (IOException e) {
	            System.out.println("write withdrawal failed");
	            e.printStackTrace();
	        }
	}
	
	/**clear the withdrawal.txt*/
	public void clearWithdrawalFile() {
		File file =new File("withdrawal.txt");
		try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("clear withdrawal success");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**get accounts from withdrawal.txt file*/
	public ArrayList<Account> getAccountFromFile() {
		ArrayList<Account> temp=null;
	    File file =new File("account.txt");
	    FileInputStream in;
	    try {
	        in = new FileInputStream(file);
	        ObjectInputStream objIn=new ObjectInputStream(in);
	        temp=(ArrayList<Account>)objIn.readObject();
	        objIn.close();
	        System.out.println("read account success!");
	    } catch (IOException e) {
	        System.out.println("read account failed");
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return temp;	
	}
	
	/**write accounts to withdrawal.txt file*/
	public void writeAccountToFile(ArrayList<Account> accounts) {
		 File file =new File("account.txt");
	     FileOutputStream out;
	        try {
	            out = new FileOutputStream(file);
	            ObjectOutputStream objOut=new ObjectOutputStream(out);
	            objOut.writeObject(accounts);
	            objOut.flush();
	            objOut.close();
	            System.out.println("write account success!");
	        } catch (IOException e) {
	            System.out.println("write account failed");
	            e.printStackTrace();
	        }
	}
	
	/**clear the withdrawal.txt*/
	public void clearAccountFile() {
		File file =new File("account.txt");
		try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("clear account success");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	/**add a new customer*/
	public void addCustomer() {
		int a = 0;
		String name = ui.text3.getText();//name
		String address = ui.text4.getText();//address
		String dateofbirth = ui.text5.getText();//date of birth
		int year=0,month,day ;//input date
		Calendar calendar = null;
		
		int yearN,monthN,dayN;//date of today
		//get the information of today
		Calendar calendarNow = new GregorianCalendar();
		calendarNow.setTime(new Date());
		yearN = calendarNow.get(Calendar.YEAR);
		monthN = calendarNow.get(Calendar.MONTH)+1;
		dayN = calendarNow.get(Calendar.DAY_OF_MONTH);
		//System.out.println(dayN);
		
		//judge whether input correct
		if(name.equals("")) {//whether the name input is null
			JOptionPane.showMessageDialog(null,"Please enter the name","tip",JOptionPane.WARNING_MESSAGE);
			a=1;
		}else if(address.equals("")) {//whether the address input is null
			JOptionPane.showMessageDialog(null,"Please enter the address","tip",JOptionPane.WARNING_MESSAGE);
			a=1;
		}else if(dateofbirth.equals("")) {//whether the dateofbirth input is null
			JOptionPane.showMessageDialog(null,"Please enter your date of birth","tip",JOptionPane.WARNING_MESSAGE);
			a=1;
		}else if(dateofbirth.length()!=8){//whether the dateofbirth input is in 8 digits
			JOptionPane.showMessageDialog(null,"Please enter your date of birth in correct format","tip",JOptionPane.WARNING_MESSAGE);
			a=1;
		}else {
			//change to integer
			year = Integer.parseInt(dateofbirth.substring(0, 4));
			month = Integer.parseInt(dateofbirth.substring(4, 6));
			day = Integer.parseInt(dateofbirth.substring(6,8));
			calendar = new GregorianCalendar(year , month, day);
			//compare whether the date of birth is earlier than today
			if(year>yearN) {
				JOptionPane.showMessageDialog(null,"You can not enter date bigger than today","tip",JOptionPane.WARNING_MESSAGE);
				a=1;
			}else if(year==yearN){
				if(month>monthN) {
					JOptionPane.showMessageDialog(null,"You can not enter date bigger than today","tip",JOptionPane.WARNING_MESSAGE);
					a=1;
				}else if(month==monthN) {
					if(day>dayN) {
						JOptionPane.showMessageDialog(null,"You can not enter date bigger than today","tip",JOptionPane.WARNING_MESSAGE);
						a=1;
					}
				}
			}	
		}
		if(a==0) {
			customerInUse = new Customer(name,address,calendar);
			customerInUse.setAge(yearN-year);
			System.out.println(customerInUse.getAge());
			customers.add(customerInUse);
			//System.out.println(customers);
			clearCustomerFile();
			writeCustomerToFile(customers);
			
			ui.addCustomerUI.setVisible(false);
			ui.confirmCreditUI.setVisible(true);
			
		}
		
		
		//System.out.println(year+month+day);
	}
	
	/**judge a current customer*/
	public void currentCustomer() {
		customers = getCustomerFromFile();
		String name = ui.text1.getText();
		int i,j=0;
		for (i = 0;i<customers.size();i++) {
			System.out.println(name);
			System.out.println(customers.get(i).getName());
			if(name.equals(customers.get(i).getName())) {
				customerInUse = customers.get(i);
				j=1;
			}
		}
		if(j==0) {
			JOptionPane.showMessageDialog(null,"The customer does not exist!","tip",JOptionPane.WARNING_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null,"Check in success!","tip",JOptionPane.WARNING_MESSAGE);
			ui.currentCustomerUI.setVisible(false);
			ui.confirmCreditUI.setVisible(true);
		}
	}
	
	/**set the credit status to true*/
	public void confirmCreditStatus() {
		customerInUse.setCreditStatus(true);
		clearCustomerFile();
		writeCustomerToFile(customers);
		JOptionPane.showMessageDialog(null,"The credit status of this customer is well!","tip",JOptionPane.WARNING_MESSAGE);
	}
	
	/**set the credit status to false*/
	public void notConfirmCreditStatus() {
		customerInUse.setCreditStatus(false);
		JOptionPane.showMessageDialog(null,"The credit status of this customer is bad, which can not open an account","tip",JOptionPane.WARNING_MESSAGE);
	}
	
	/**create the account*/
	public void createAccount() {
		accounts = getAccountFromFile();
		
		accNumber = 100001+accounts.size();
		ui.label8.setText("The account number is:  "+accNumber);
		if(chosenAcc==1) { //saver account
			SaverAccount acc = new SaverAccount(accNumber,customerInUse);
			accountInUse = acc;
			ui.chooseAccUI.setVisible(false);
			ui.enterPinUI.setVisible(true);
			
		}else if(chosenAcc==2) {//junior account
			if(customerInUse.getAge()<16) {
				JuniorAccount acc = new JuniorAccount(accNumber,customerInUse);
				accountInUse = acc;
				ui.chooseAccUI.setVisible(false);
				ui.enterPinUI.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null,"Customer over 16 can not create junior account","tip",JOptionPane.WARNING_MESSAGE);
			}
			
		}else if(chosenAcc==3) {//current account
			CurrentAccount acc = new CurrentAccount(accNumber,customerInUse);
			accountInUse = acc;
			ui.chooseAccUI.setVisible(false);
			ui.enterPinUI.setVisible(true);
		}
	}
	
	/**enter the pin*/
	public void setPin() {
		if(ui.text2.getText().length()!=6) {
			JOptionPane.showMessageDialog(null,"Please enter the pin of 6 digits","tip",JOptionPane.WARNING_MESSAGE);
		}else {
			//ui.label8.setText("The account number is:  "+accNumber);
			int pin = Integer.parseInt(ui.text2.getText());
			accountInUse.setPin(pin);
			customerInUse.accounts.add(accountInUse);
			accounts.add(accountInUse);
			
			for(int i=0;i<customers.size();i++) {
				if(customers.get(i).getName()==customerInUse.getName()) {
					customers.get(i).accounts =customerInUse.accounts;
				}
			}
			clearCustomerFile();
			writeCustomerToFile(customers);
			clearAccountFile();
			writeAccountToFile(accounts);
			
			JOptionPane.showMessageDialog(null,"Create account in success","tip",JOptionPane.WARNING_MESSAGE);
			ui.enterPinUI.setVisible(false);
			ui.mainUI.setVisible(true);
		}
		
		
	}
	
	/**make a deposit*/
	public void deposit() {
		int accNo = Integer.parseInt(ui.text8.getText());
		int amount = Integer.parseInt(ui.text9.getText());
		accounts = getAccountFromFile();
		int i,j=0;
		for(i=0;i<accounts.size();i++) {
			if(accNo == accounts.get(i).getAccNo()) {
				accountInUse = accounts.get(i);
				j=1;
			}
		}
		if(j==0) {
			JOptionPane.showMessageDialog(null,"The account does not exist","tip",JOptionPane.WARNING_MESSAGE);
		}else if(accountInUse.isActive==false){
			JOptionPane.showMessageDialog(null,"The account has been closed","tip",JOptionPane.WARNING_MESSAGE);
		}else if(accountInUse.isSuspended == true){
			JOptionPane.showMessageDialog(null,"The account has been suspended, which can not make transaction!","tip",JOptionPane.WARNING_MESSAGE);
		}else {
			
			JOptionPane.showMessageDialog(null,"deposit in success","tip",JOptionPane.WARNING_MESSAGE);
			Calendar date = new GregorianCalendar();
			
			date.setTime(new Date());
			Deposit deposit = new Deposit(amount,date);
			deposits = getDepositFromFile();
			deposits.add(deposit);
			clearDepositFile();
			writeDepositToFile(deposits);
			
			if(ui.radio1.isSelected()) { //cash
				accountInUse.addBalance(amount);
			}else {//cheque
				accountInUse.uncreditAmount = accountInUse.uncreditAmount + amount;
			}
			for(i=0;i<accounts.size();i++) {
				if(accNo == accounts.get(i).getAccNo()) {
					accounts.get(i).balance = accountInUse.balance;
					System.out.println(accounts.get(i).balance);
					accounts.get(i).uncreditAmount = accountInUse.uncreditAmount;
				}
			}
			clearAccountFile();
			writeAccountToFile(accounts);
			
			ui.depositUI.setVisible(false);
			ui.customerUI.setVisible(true);
			
		}
		
		
	}
	
	/**make a withdraw*/
	public void withdraw() {
		int accNo = Integer.parseInt(ui.text10.getText());
		int pin = Integer.parseInt(ui.text11.getText());
		int amount = Integer.parseInt(ui.text12.getText());
		
		//accounts = new ArrayList<Account>();
		accounts = getAccountFromFile();
		
		int i,j=0;
		for(i=0;i<accounts.size();i++) {
			if(accNo == accounts.get(i).getAccNo()) {
				accountInUse = accounts.get(i);
				//System.out.println(accounts.get(i).getAccNo());
				j=1;
			}
		}
		if(j==0) {
			JOptionPane.showMessageDialog(null,"The account does not exist!","tip",JOptionPane.WARNING_MESSAGE);
		}else if(pin!=accountInUse.getPin()){
			JOptionPane.showMessageDialog(null,"The pin of this account is not right!","tip",JOptionPane.WARNING_MESSAGE);
		}else if(amount>accountInUse.getBalance()+accountInUse.overDraftLimit){
			JOptionPane.showMessageDialog(null,"You can not withdraw more than the account has!","tip",JOptionPane.WARNING_MESSAGE);
		}else if(accountInUse.isActive==false) {
			JOptionPane.showMessageDialog(null,"The account has been closed","tip",JOptionPane.WARNING_MESSAGE);
		}else if(accountInUse.isSuspended==true){
			JOptionPane.showMessageDialog(null,"The account has been suspended, which can not make transaction!","tip",JOptionPane.WARNING_MESSAGE);
		}else {
			
			Calendar date = new GregorianCalendar();
			date.setTime(new Date());
			/*Withdrawal withdrawal = new Withdrawal(amount,date);//create a new withdrawal
			withdrawals = getWithdrawalFromFile();
			withdrawals.add(withdrawal);//add it to the arraylist in the system
			clearWithdrawalFile();
			writeWithdrawalToFile(withdrawals);*/
			
			if(accountInUse.noticeNeeded == true) {//saver account
				
				acc1 = (SaverAccount) accountInUse;
				if(acc1.getNoticeDate().get(Calendar.YEAR)==1000) {
					JOptionPane.showMessageDialog(null,"Please set the notice!","tip",JOptionPane.WARNING_MESSAGE);
					ui.withdrawUI.setVisible(false);
					ui.setNoticeUI.setVisible(true);
				}else if(acc1.getNoticeDate().get(Calendar.YEAR) == date.get(Calendar.YEAR) && acc1.getNoticeDate().get(Calendar.MONTH) == date.get(Calendar.MONTH)+1 && acc1.getNoticeDate().get(Calendar.DAY_OF_MONTH) == date.get(Calendar.DAY_OF_MONTH)) {
					acc1.subBalance(amount);
					
					//update the file
					for(i=0;i<accounts.size();i++) {
						if(accNo == accounts.get(i).getAccNo()) {
							accounts.get(i).balance = acc1.balance;
							accounts.get(i).overDraftLimit = acc1.overDraftLimit;
							System.out.println(accounts.get(i).balance);	
						}
					}
					clearAccountFile();
					writeAccountToFile(accounts);
					JOptionPane.showMessageDialog(null,"Withdraw success!","tip",JOptionPane.WARNING_MESSAGE);
					
					Withdrawal withdrawal = new Withdrawal(amount,date);//create a new withdrawal
					withdrawals = getWithdrawalFromFile();
					withdrawals.add(withdrawal);//add it to the arraylist in the system
					clearWithdrawalFile();
					writeWithdrawalToFile(withdrawals);
					
					ui.withdrawUI.setVisible(false);
					ui.customerUI.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null,"Please check the notice! You can not withdraw until the notice date","tip",JOptionPane.WARNING_MESSAGE);
				}
			}else {//junior and current account
				accountInUse.subBalance(amount);
				System.out.println(accountInUse.getBalance());
				for(i=0;i<accounts.size();i++) {
					if(accNo == accounts.get(i).getAccNo()) {
						accounts.get(i).balance = accountInUse.balance;
						accounts.get(i).overDraftLimit = accountInUse.overDraftLimit;
						System.out.println(accounts.get(i).balance);	
					}
				}
				clearAccountFile();
				writeAccountToFile(accounts);
				JOptionPane.showMessageDialog(null,"Withdraw success!","tip",JOptionPane.WARNING_MESSAGE);
				
				Withdrawal withdrawal = new Withdrawal(amount,date);//create a new withdrawal
				withdrawals = getWithdrawalFromFile();
				withdrawals.add(withdrawal);//add it to the arraylist in the system
				clearWithdrawalFile();
				writeWithdrawalToFile(withdrawals);
				
				ui.withdrawUI.setVisible(false);
				ui.customerUI.setVisible(true);
			}
			
		}
	}
	
	/**check the balance*/
	public void checkBalance() {
		if(ui.text13.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter the account number","tip",JOptionPane.WARNING_MESSAGE);
		}else if(ui.text14.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Please enter the pin","tip",JOptionPane.WARNING_MESSAGE);
		}else {
			int accNo = Integer.parseInt(ui.text13.getText());
			int pin = Integer.parseInt(ui.text14.getText());
			accounts = getAccountFromFile();
			int i,j=0;
			for(i=0;i<accounts.size();i++) {
				if(accNo == accounts.get(i).getAccNo()) {
					accountInUse = accounts.get(i);
					j=1;
				}
			}
			if(j==0) {
				JOptionPane.showMessageDialog(null,"The account number does not exist!","tip",JOptionPane.WARNING_MESSAGE);
			}else if(accountInUse.getPin()!=pin) {
				JOptionPane.showMessageDialog(null,"The pin is not right!","tip",JOptionPane.WARNING_MESSAGE);
			}else {
				ui.label25.setText("The balance of this account:   "+accountInUse.getBalance());
				ui.label26.setText("The notcredit amount:    "+accountInUse.uncreditAmount);
				ui.label27.setText("The overdraft limit:    "+accountInUse.overDraftLimit);
				
				ui.checkBalanceUI.setVisible(false);
				ui.balanceUI.setVisible(true);
			}
		}
		
	}
	
	/**the external service clear the funds*/
	public void clearFunds() {
		accounts = getAccountFromFile();
		for (int i=0;i<accounts.size();i++) {
			accounts.get(i).balance = accounts.get(i).balance + accounts.get(i).uncreditAmount;
			accounts.get(i).uncreditAmount =0;
		}
		clearAccountFile();
		writeAccountToFile(accounts);
		JOptionPane.showMessageDialog(null,"Clear the uncredit amount success","tip",JOptionPane.WARNING_MESSAGE);
	}
	
	/**for saver account we need to set notice amount and date*/
	public void giveNotice() {
		String noticeDate = ui.text15.getText();//notice date
		int year,month,day ;//input date
		Calendar calendar = null;
		year = Integer.parseInt(noticeDate.substring(0, 4));
		month = Integer.parseInt(noticeDate.substring(4, 6));
		day = Integer.parseInt(noticeDate.substring(6,8));
		calendar = new GregorianCalendar(year , month, day);
		int amount = Integer.parseInt(ui.text16.getText());
		
		acc1.setNotice(calendar,amount);
		
		//update the file
		for(int i=0;i<accounts.size();i++) {
			if(acc1.accNo == accounts.get(i).getAccNo()) {
				accounts.set(i, acc1);
				System.out.println(accounts.get(i).noticeNeeded);
			}
		}
		clearAccountFile();
		writeAccountToFile(accounts);
		JOptionPane.showMessageDialog(null,"Set notice success!","tip",JOptionPane.WARNING_MESSAGE);
		
		ui.setNoticeUI.setVisible(false);
		ui.customerUI.setVisible(true);
		
	}
	
	/**suspend an account*/
	public void suspend() {
		if(ui.text6.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter the account number","tip",JOptionPane.WARNING_MESSAGE);
		}else {
			int accNo = Integer.parseInt(ui.text6.getText());
			accounts = getAccountFromFile();
			int i,j=0;
			for(i=0;i<accounts.size();i++) {
				if(accNo == accounts.get(i).getAccNo()) {
					accountInUse = accounts.get(i);
					j=1;
				}
			}
			if(j==0) {
				JOptionPane.showMessageDialog(null,"The account number does not exist!","tip",JOptionPane.WARNING_MESSAGE);
			}else {
				accountInUse.setSuspended(true);
				for(i=0;i<accounts.size();i++) {
					if(accNo == accounts.get(i).getAccNo()) {
						accounts.set(i, accountInUse);
						j=i;
					}
				}
				System.out.println(accounts.get(j).isSuspended());
				
				JOptionPane.showMessageDialog(null,"Suspend success!","tip",JOptionPane.WARNING_MESSAGE);
				
				clearAccountFile();
				writeAccountToFile(accounts);
				
				ui.suspendAccUI.setVisible(false);
				ui.employeeUI.setVisible(true);
			}
		}
	}
	
	/**reinitiate an account*/
	public void reinitiate() {
		if(ui.text6.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter the account number","tip",JOptionPane.WARNING_MESSAGE);
		}else {
			int accNo = Integer.parseInt(ui.text6.getText());
			accounts = getAccountFromFile();
			int i,j=0;
			for(i=0;i<accounts.size();i++) {
				if(accNo == accounts.get(i).getAccNo()) {
					accountInUse = accounts.get(i);
					j=1;
				}
			}
			if(j==0) {
				JOptionPane.showMessageDialog(null,"The account number does not exist!","tip",JOptionPane.WARNING_MESSAGE);
			}else {
				accountInUse.setSuspended(false);
				for(i=0;i<accounts.size();i++) {
					if(accNo == accounts.get(i).getAccNo()) {
						accounts.set(i, accountInUse);
						System.out.println(accounts.get(i).isSuspended());
					}
				}
				JOptionPane.showMessageDialog(null,"Reinitiate success","tip",JOptionPane.WARNING_MESSAGE);
				clearAccountFile();
				writeAccountToFile(accounts);
				ui.suspendAccUI.setVisible(false);
				ui.employeeUI.setVisible(true);
			}
		}
	}
	
	/**close an account*/
	public void closeAccount() {
		if(ui.text7.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter the account number","tip",JOptionPane.WARNING_MESSAGE);
		}else {
			int accNo = Integer.parseInt(ui.text7.getText());
			accounts = getAccountFromFile();
			int i,j=0;
			for(i=0;i<accounts.size();i++) {
				if(accNo == accounts.get(i).getAccNo()) {
					accountInUse = accounts.get(i);
					j=1;
				}
			}
			if(j==0) {
				JOptionPane.showMessageDialog(null,"The account number does not exist!","tip",JOptionPane.WARNING_MESSAGE);
			}else if(accountInUse.getBalance()!=0){
				JOptionPane.showMessageDialog(null,"The balance must be 0 if to be closed","tip",JOptionPane.WARNING_MESSAGE);
			}else {
				accountInUse.isActive = false;
				for(i=0;i<accounts.size();i++) {
					if(accNo == accounts.get(i).getAccNo()) {
						accounts.set(i, accountInUse);
						System.out.println(accounts.get(i).isActive);
					}
				}
				JOptionPane.showMessageDialog(null,"Close account success","tip",JOptionPane.WARNING_MESSAGE);
				clearAccountFile();
				writeAccountToFile(accounts);
				ui.cancelAccUI.setVisible(false);
				ui.employeeUI.setVisible(true);
			}
		}
	}
	
	/**actionlistener in general*/
	
	class numKeyListener implements KeyListener{
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			int keyChar = e.getKeyChar();				
			if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
				
			}else{
				e.consume(); //ignore unrequired input
			}
			
			
		}
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	/**actionlistener in mainUI*/
	class employeeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.mainUI.setVisible(false);
			ui.employeeUI.setVisible(true);
		}
	}
	class customerListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.mainUI.setVisible(false);
			ui.customerUI.setVisible(true);
		}
	}
	class externalListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			clearFunds();
		}	
	}
	
	/**actionlistener in employeeUI*/
	class openAccListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.employeeUI.setVisible(false);
			ui.createAccUI.setVisible(true);
		}	
	}
	class suspendAccListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.employeeUI.setVisible(false);
			ui.suspendAccUI.setVisible(true);
		}
	}
	class closeAccListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.employeeUI.setVisible(false);
			ui.cancelAccUI.setVisible(true);
		}
	}
	class employeeBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.mainUI.setVisible(true);
			ui.employeeUI.setVisible(false);
		}
	}
	
	/**actionlistener in createAccUI*/
	class currentListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.createAccUI.setVisible(false);
			ui.currentCustomerUI.setVisible(true);
		}
	}
	class newListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.createAccUI.setVisible(false);
			ui.addCustomerUI.setVisible(true);
			
		}
	}
	
	/**actionlistener in currentCustomerUI*/
	class currentCheckListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			currentCustomer();
		}
	}
	class currentBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.currentCustomerUI.setVisible(false);
			ui.employeeUI.setVisible(true);
		}
	}
	
	/**actionlistener in addCustomerUI*/
	class addCustomerConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			addCustomer();
		}
	}
	class addCustomerCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.addCustomerUI.setVisible(false);
			ui.employeeUI.setVisible(true);
		}
	}
	
	/**actionlistener in confirmCreditUI*/
	class confirmCreditListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.confirmCreditUI.setVisible(false);
			ui.chooseAccUI.setVisible(true);
			confirmCreditStatus();
		}
	}
	class notConfirmCreditListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.confirmCreditUI.setVisible(false);
			ui.employeeUI.setVisible(true);
			notConfirmCreditStatus();
		}
	}
	
	/**actionlistener in chooseAccUI*/
	class saverAccListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			chosenAcc = 1;
			createAccount();
		}
	}
	class juniorAccListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			chosenAcc = 2;
			createAccount();
		}
	}
	class currentAccListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			chosenAcc = 3;
			createAccount();
		}
	}
	class chooseAccBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.chooseAccUI.setVisible(false);
			ui.employeeUI.setVisible(true);
		}
	}
	
	/**actionlistener in enterPinUI*/
	class confirmPinUIListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setPin();
			
		}
		
	}
	
	/**actionlistener in customerUI*/
	class depositListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.customerUI.setVisible(false);
			ui.depositUI.setVisible(true);
		}
	}
	class withdrawListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.customerUI.setVisible(false);
			ui.withdrawUI.setVisible(true);
		}
	}
	class checkBalanceListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.customerUI.setVisible(false);
			ui.checkBalanceUI.setVisible(true);
		}	
	}
	class customerBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.customerUI.setVisible(false);
			ui.mainUI.setVisible(true);
		}
	}
	
	/**actionlistener in depositUI*/
	class depositConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			deposit();
		}
	}
	class depositCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.depositUI.setVisible(false);
			ui.customerUI.setVisible(true);
		}
	}
	
	/**actionlistener in withdrawUI*/
	class withdrawConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			withdraw();
		}
	}
	class withdrawCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.withdrawUI.setVisible(false);
			ui.customerUI.setVisible(true);
			
		}
		
	}
	
	
	/**actionlistener in checkBalanceUI*/
	class checkBalanceConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			checkBalance();
		}
	}
	class checkBalanceBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.checkBalanceUI.setVisible(false);
			ui.customerUI.setVisible(true);
		}
		
	}
	
	/**actionlistener in BalanceUI*/
	class balanceBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.balanceUI.setVisible(false);
			ui.customerUI.setVisible(true);
			
		}
		
	}
	
	/**actionlistener in setNoticeUI*/
	class setNoticeConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			giveNotice();
		}
	}
	class setNoticeBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.setNoticeUI.setVisible(false);
			ui.customerUI.setVisible(true);
		}
		
	}
	
	/**actionlistener in suspendAccUI*/
	class suspendListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			suspend();		
		}
	}
	class reinitiateListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			reinitiate();
		}
	}
	
	/**actionlistener in cancelAccUI*/
	class closeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			closeAccount();
		}
	}
	class cancelAccBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ui.cancelAccUI.setVisible(false);
			ui.employeeUI.setVisible(true);
			
		}
		
	}

	
	
	public static void main(String args[]) throws IOException {
		BankControl bank = new BankControl();
		
		/**initiate a customer*/
		Calendar calendar = new GregorianCalendar(1998,11,11);
    	Customer customer = new Customer("Sang","bupt",calendar);
    	bank.customers.add(customer);
    	Deposit deposit = new Deposit(1000,calendar);
    	bank.deposits.add(deposit);
    	Withdrawal withdrawal = new Withdrawal(1000,calendar);
    	bank.withdrawals.add(withdrawal);
    	Account account = new Account(100001,customer);
    	account.setPin(123456);
    	bank.accounts.add(account);
		
		/**initiate if the files do not exist*/
		File file1 =new File("customer.txt");
        if(!file1.exists()) {
        	bank.writeCustomerToFile(bank.customers);
        }
        
		File file2 =new File("deposit.txt");
		if(!file2.exists()) {
        	bank.writeDepositToFile(bank.deposits);
        }
		
		File file3 =new File("withdrawal.txt");
		if(!file3.exists()) {
			bank.writeWithdrawalToFile(bank.withdrawals);
        }
		
		File file4 =new File("account.txt");
		if(!file4.exists()) {
        	bank.writeAccountToFile(bank.accounts);
        }
		
		/**print all the account number*/
		bank.accounts = bank.getAccountFromFile();
		for(int i=0;i<bank.accounts.size();i++) {
			System.out.println(bank.accounts.get(i).accNo);
		}
			
		
		
			
	}
}
