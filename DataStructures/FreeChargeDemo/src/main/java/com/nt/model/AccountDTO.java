package com.nt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class AccountDTO
{
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("balance")
    private String balance;
    @JsonProperty("interestRate")
    private String interestRate;
    @JsonProperty("openingBalance")
    private String openingBalance;
    @JsonProperty("openingDate")
    private String openingDate;
    @JsonProperty("closingDate")
    private String closingDate;
    @JsonProperty("accountStatus")
    private String accountStatus;
    @JsonProperty("minimumBalance")
    private String minimumBalance;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(String openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(String minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

}
