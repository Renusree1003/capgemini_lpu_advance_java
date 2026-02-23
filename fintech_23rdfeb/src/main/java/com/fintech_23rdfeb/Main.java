package com.fintech_23rdfeb;



import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAO();
        BankAccountDAO accountDAO = new BankAccountDAO();
        TransactionDAO transactionDAO = new TransactionDAO();
        CardDAO cardDAO = new CardDAO();

        // Add Customer
        Customer customer = new Customer("Renusree", "renu@gmail.com", "9876543210");
        customerDAO.save(customer);

        // Create Bank Account
        BankAccount account = new BankAccount("ACC1001", "SAVINGS", new BigDecimal("50000"));
        accountDAO.save(account);

        //  Link Account to Customer
        accountDAO.linkToCustomer(1L, 1L);

        // Add Transaction
        Transaction txn = new Transaction("CREDIT",
                new BigDecimal("2000"),
                "Salary Credit",
                "ABC123");
        transactionDAO.save(txn, 1L);

        //  Issue Card
        Card card = new Card("1234567890",
                "DEBIT",
                "VISA",
                LocalDate.parse("23-02-2026"));

        cardDAO.issueCard(card, 1L);

        //  Assign Card to Customer
        cardDAO.assignCardToCustomer(1L, 1L);

        //  Deactivate Card
        cardDAO.deactivateCard(1L);

       
    }
}
