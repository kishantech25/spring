package com.nt.config;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ACCOUNTS")
public class Accounts {

    @Id
    @Column(name = "ACCOUNT_ID")
    private Integer accountId;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Integer customerId;

    @Column(name = "ACCOUNT_NUMBER", length = 20, nullable = false)
    private String accountNumber;

    @Column(name = "ACCOUNT_TYPE", length = 20, nullable = false)
    private String accountType;

    @Column(name = "CURRENCY", length = 3)
    private String currency;

    @Column(name = "BALANCE", precision = 15, scale = 2, nullable = false)
    private BigDecimal balance;

    @Column(name = "INTEREST_RATE", precision = 5, scale = 2)
    private BigDecimal interestRate;

    @Column(name = "OPENING_BALANCE", precision = 15, scale = 2, nullable = false)
    private BigDecimal openingBalance;

    @Temporal(TemporalType.DATE)
    @Column(name = "OPENING_DATE", nullable = false)
    private Date openingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "CLOSING_DATE")
    private Date closingDate;

    @Column(name = "ACCOUNT_STATUS", length = 15)
    private String accountStatus;

    @Column(name = "MINIMUM_BALANCE", precision = 15, scale = 2)
    private BigDecimal minimumBalance;

    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    private Timestamp updatedAt;

    public Accounts() {
    }

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public BigDecimal getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public BigDecimal getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(BigDecimal minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

    // Keep all your getters, setters, constructors and toString() unchanged
}