package com.fintech_23rdfeb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardId;

    private String cardNumber;
    private String cardType;
    private String cardNetwork;
    private LocalDate expiryDate;
    private Boolean isActive = true;
    
    @ManyToOne
    @JoinColumn
    private BankAccount bankAccount;
    @ManyToMany(mappedBy="cards")
    private List<Customer> customers = new ArrayList<>();
    
    Card(){
    	
    }
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public Long getCardId() {
		return cardId;
	}
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNetwork() {
		return cardNetwork;
	}
	public void setCardNetwork(String cardNetwork) {
		this.cardNetwork = cardNetwork;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Card(String cardNumber, String cardType, String cardNetwork, LocalDate expiryDate) {
	    this.cardNumber = cardNumber;
	    this.cardType = cardType;
	    this.cardNetwork = cardNetwork;
	    this.expiryDate = expiryDate;
	    this.isActive = true;
	}
	
	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardNumber=" + cardNumber + ", cardType=" + cardType + ", cardNetwork="
				+ cardNetwork + ", expiryDate=" + expiryDate + ", isActive=" + isActive + "]";
	}
    
    

}
