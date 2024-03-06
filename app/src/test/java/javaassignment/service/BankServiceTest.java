package javaassignment.service;
/*Generate unit test cases for BankService service using Junit Jupiter
 * Test the following methods:
 * openSBAccount
 * depositeInSBAccount
 * withdrawFromSBAccount
 * openFDAccount
 * getTenure
 * getMaturityAmount
 * Write some negative test cases as well
 * 
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;



import javaassignment.exception.InsufficientBalanceException;
import javaassignment.model.FDAccount;
import javaassignment.model.SBAccount;

import org.junit.jupiter.api.Test;

public class BankServiceTest {
    BankService bankService = BankService.getInstance();
    @Test
    public void testOpenSBAccount() {
        SBAccount sbAccount = bankService.openSBAccount(1, LocalDate.now(), 1000, 10000);
        assertEquals(1, sbAccount.getAccountNumber());
        assertEquals(LocalDate.now(), sbAccount.getOpeningDate());
        assertEquals(10000, sbAccount.getBalance());
        assertEquals(1000, sbAccount.getMinBalance());
    }

    @Test
    public void testDepositeInSBAccount() {
        SBAccount sbAccount = bankService.openSBAccount(1, LocalDate.now(), 1000, 10000);
        sbAccount = bankService.depositeInSBAccount(sbAccount, 5000);
        assertEquals(15000, sbAccount.getBalance());
    }

    @Test
    public void testWithdrawFromSBAccount() throws InsufficientBalanceException {
        SBAccount sbAccount = bankService.openSBAccount(1, LocalDate.now(), 1000, 10000);
        sbAccount = bankService.depositeInSBAccount(sbAccount, 5000);
        sbAccount = bankService.withdrawFromSBAccount(sbAccount, 2000);
        assertEquals(13000, sbAccount.getBalance());
    }

    @Test
    public void testWithdrawFromSBAccountWithInsufficientBalance() {
        SBAccount sbAccount = bankService.openSBAccount(1, LocalDate.now(), 1000, 13000);
        InsufficientBalanceException exception = assertThrows(InsufficientBalanceException.class, () -> {
            bankService.withdrawFromSBAccount(sbAccount, 12500);
        });
        String expectedMessage = "Insufficient balance";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testOpenFDAccount() {
        FDAccount fdAccount = bankService.openFDAccount(2, LocalDate.now(), LocalDate.now().plusYears(2), 5, 10000);
        assertEquals(2, fdAccount.getAccountNumber());
        assertEquals(LocalDate.now(), fdAccount.getOpeningDate());
        assertEquals(LocalDate.now().plusYears(2), fdAccount.getMaturityDate());
        assertEquals(5, fdAccount.getInterestRate());
        assertEquals(10000, fdAccount.getBalance());
    }

    @Test
    public void testGetTenure() {
        FDAccount fdAccount = bankService.openFDAccount(2, LocalDate.now(), LocalDate.now().plusYears(2), 5, 10000);
        assertEquals(24, bankService.getTenure(fdAccount));
    }

    @Test
    public void testGetMaturityAmount() {
        FDAccount fdAccount = bankService.openFDAccount(2, LocalDate.now(), LocalDate.now().plusYears(2), 5, 10000);
        assertEquals(11000, bankService.getMaturityAmount(fdAccount));
    }
}
