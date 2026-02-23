package com.fintech_23rdfeb;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
    private String txnType;
    private BigDecimal amount;
    private LocalDateTime txnDate;
    private String description;
    private String referenceNumber;
    
    @ManyToOne
    @JoinColumn
    private BankAccount bankAccount;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDateTime getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(LocalDateTime txnDate) {
		this.txnDate = txnDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	
	public Transaction() {
	}

	public Transaction(String txnType, BigDecimal amount, String description, String referenceNumber) {
	    this.txnType = txnType;
	    this.amount = amount;
	    this.description = description;
	    this.referenceNumber = referenceNumber;
	    this.txnDate = LocalDateTime.now();
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", txnType=" + txnType + ", description=" + description
				+ ", referenceNumber=" + referenceNumber + "]";
	}
    
    

}
