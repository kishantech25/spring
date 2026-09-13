package com.nt.service;

import com.nt.config.Accounts;
import com.nt.model.AccountDTO;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.Date;

public class Mapper {

    public static Accounts mapAccountsToAccountDto(AccountDTO dto) {
        Accounts account = new Accounts();
        account.setAccountId(parseInteger(dto.getAccountId(), "accountId"));
        account.setCustomerId(parseInteger(dto.getCustomerId(), "customerId"));
        account.setAccountNumber(dto.getAccountNumber());
        account.setAccountType(dto.getAccountType());
        account.setCurrency(dto.getCurrency());
        account.setBalance(parseBigDecimal(dto.getBalance(), "balance"));
        account.setInterestRate(parseBigDecimal(dto.getInterestRate(), "interestRate"));
        account.setOpeningBalance(parseBigDecimal(dto.getOpeningBalance(), "openingBalance"));
        account.setOpeningDate(parseDate(dto.getOpeningDate(), "openingDate"));
        account.setClosingDate(parseDate(dto.getClosingDate(), "closingDate"));
        account.setAccountStatus(dto.getAccountStatus());
        account.setMinimumBalance(parseBigDecimal(dto.getMinimumBalance(), "minimumBalance"));
        return account;
    }

    public static Accounts map(AccountDTO dto) {
        return mapAccountsToAccountDto(dto);
    }

    private static Integer parseInteger(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid " + fieldName + ": " + value, ex);
        }
    }

    private static BigDecimal parseBigDecimal(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            return new BigDecimal(value.trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid " + fieldName + ": " + value, ex);
        }
    }

    private static Date parseDate(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        String trimmed = value.trim();
        try {
            return java.sql.Date.valueOf(trimmed);
        } catch (IllegalArgumentException ex) {
            try {
                return Date.from(Instant.parse(trimmed));
            } catch (DateTimeException innerEx) {
                throw new IllegalArgumentException("Invalid " + fieldName + ": " + value, innerEx);
            }
        }
    }



}
