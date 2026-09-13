package com.springjdbc.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Statement {

    private int statementId;
    private int accountId;
    private Timestamp txnDateTime;
    private String summary;
    private BigDecimal debit;
    private BigDecimal credit;
    private BigDecimal balance;

    public int getStatementId() {
        return statementId;
    }

    public void setStatementId(int statementId) {
        this.statementId = statementId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Timestamp getTxnDateTime() {
        return txnDateTime;
    }

    public void setTxnDateTime(Timestamp txnDateTime) {
        this.txnDateTime = txnDateTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "statementId=" + statementId +
                ", accountId=" + accountId +
                ", txnDateTime=" + txnDateTime +
                ", summary='" + summary + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", balance=" + balance +
                '}';
    }
}
