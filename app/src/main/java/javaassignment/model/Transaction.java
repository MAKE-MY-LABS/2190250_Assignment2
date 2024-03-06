/**
 * Transaction class is used to store the transaction details like transactionDate, transactionType and transactionAmount
 * This class is created with builder pattern with single input argument constructor with builder as input argument
 */
package javaassignment.model;

import java.time.LocalDate;


public class Transaction {
    private LocalDate transactionDate;
    private TransactionType transactionType;
    private double transactionAmount;

    public Transaction(Builder builder) {
        this.transactionDate = builder.transactionDate;
        this.transactionType = builder.transactionType;
        this.transactionAmount = builder.transactionAmount;
    }

    public static class Builder {
        private LocalDate transactionDate;
        private TransactionType transactionType;
        private double transactionAmount;

        public Builder transactionDate(LocalDate transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public Builder transactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder transactionAmount(double transactionAmount) {
            this.transactionAmount = transactionAmount;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    public enum TransactionType {
        CREDIT, DEBIT
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    
}