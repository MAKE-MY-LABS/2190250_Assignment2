/**
 * This class is an abstract class that represents an account. It has an account number, a list of transactions, a balance and an opening date.
 * It has a method to deposit money into the account and a method to get the account details.
 * 	
 */
package javaassignment.model;

import java.time.LocalDate;
import java.util.List;

public abstract class Account {
	protected int accountNumber;
	protected List<Transaction> transactionList;
	protected double balance;
	protected LocalDate openingDate;
	
	public Account(int accountNumber, LocalDate openingDate, double balance, List<Transaction> transactionList) {
		this.accountNumber = accountNumber;
		this.openingDate = openingDate;
		this.transactionList = transactionList;
		this.balance = balance;
	}
	
	public void deposite(double amount) {
		Transaction transaction = new Transaction.Builder()
				.transactionDate(LocalDate.now())
				.transactionType(Transaction.TransactionType.CREDIT)
				.transactionAmount(amount)
				.build();
		this.transactionList.add(transaction);
		this.balance += amount;
	}
	
	public String getAccountDetails() {
		return "Account Number: " + this.accountNumber + "\n" +
				"Opening Date: " + this.openingDate + "\n" +
				"Balance: " + this.balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public double getBalance() {
		return balance;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	//Write a method to get all transaction details printed in the string format
	public String getTransactionDetails() {
		String transactionDetails = "";
		for (Transaction transaction : transactionList) {
			transactionDetails += "Transaction Date: " + transaction.getTransactionDate() + "\n" +
					"Transaction Type: " + transaction.getTransactionType() + "\n" +
					"Transaction Amount: " + transaction.getTransactionAmount() + "\n";
		}
		return transactionDetails;
	}
	

}