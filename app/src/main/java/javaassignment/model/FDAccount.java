/*
 * Create FDAccount class which extends Account class with attributes
 * maturityDate as LocalDate and interestRate as double as % per annum
 * With following methods: 
 * getTenure: returns the tenure of the account in months
 * getMaturityAmount: returns the maturity amount of the account after calculating interest using interestRate as % per annum and tenure converting it into years
 */
package javaassignment.model;

import java.time.LocalDate;
import java.util.List;

public class FDAccount extends Account {
    private LocalDate maturityDate;
    private double interestRate;

    public FDAccount(int accountNumber, LocalDate openingDate, LocalDate maturityDate, double interestRate, double balance, List<Transaction> transactionList) {
        super(accountNumber, openingDate, balance, transactionList);
        this.maturityDate = maturityDate;
        this.interestRate = interestRate;
    }
    //Get the maturity date
    public LocalDate getMaturityDate() {
        return maturityDate;
    }
    //Get the interest rate
    public double getInterestRate() {
        return interestRate;
    }
    
    //Get the tenure in months
    public int getTenure() {
        return (int) (this.getOpeningDate().until(this.maturityDate).toTotalMonths());
    }

    public double getMaturityAmount() {
        double tenure = this.getTenure() / 12.0;
        return this.getBalance() + (this.getBalance() * this.interestRate * tenure / 100);
    }

    @Override
    public String getAccountDetails() {
        return "Account Number: " + this.getAccountNumber() + "\n" +
                "Opening Date: " + this.getOpeningDate() + "\n" +
                "Balance: " + this.getBalance() + "\n" +
                "Maturity Date: " + this.maturityDate + "\n" +
                "Interest Rate: " + this.interestRate;
    }
}






