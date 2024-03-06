/*
 * Create InsufficientBalanceException class which extends Exception and takes message as parameter
 */
package javaassignment.exception;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        //Please check input message. If its there then return message else return "Insufficient balance in account"
        super(null != message ? message : "Insufficient balance in account");
    }
}
