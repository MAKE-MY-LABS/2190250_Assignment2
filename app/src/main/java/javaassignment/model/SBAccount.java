
/*
 * Create SBAccount class which extends Account class with minBalance property as double
 * With following methods: 
 * withdraw: Adds debit transaction to transaction list for each withdraw and updates balance also it throws exception InsufficientBalanceException if balance is not available
 */
package javaassignment.model;

import java.time.LocalDate;
import java.util.List;
import javaassignment.exception.InsufficientBalanceException;

public class SBAccount extends Account {
    private double minBalance;

    public SBAccount(int accountNumber, LocalDate openingDate, double minBalance, double balance, List<Transaction> transactionList) {
        super(accountNumber, openingDate, balance, transactionList);
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }
    
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (this.balance - amount < this.minBalance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        Transaction transaction = new Transaction.Builder()
                .transactionDate(LocalDate.now())
                .transactionType(Transaction.TransactionType.DEBIT)
                .transactionAmount(amount)
                .build();
        super.getTransactionList().add(transaction);
        super.setBalance(super.getBalance() - amount);
    }

    @Override
    public String getAccountDetails() {
        return "Account Number: " + this.getAccountNumber() + "\n" +
                "Opening Date: " + this.getOpeningDate() + "\n" +
                "Balance: " + this.getBalance() + "\n" +
                "Min Balance: " + this.minBalance;
    }
}


