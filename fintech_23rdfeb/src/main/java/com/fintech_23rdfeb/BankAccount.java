package com.fintech_23rdfeb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private String accountNumber;
	private String accountType;
	private BigDecimal balance;
	
	@OneToOne
	@JoinColumn
	private Customer customer;
	
	@OneToMany(mappedBy="bankAccount")
	private List<Transaction> transactions = new ArrayList<>();
	
	BankAccount(){
		
	}
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	

	public BankAccount(String accountNumber, String accountType, BigDecimal balance) {
	    this.accountNumber = accountNumber;
	    this.accountType = accountType;
	    this.balance = balance;
	}


	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", balance=" + balance + "]";
	}

}
