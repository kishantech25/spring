package com.records.RecordsJava17DemoOther.service;

import com.records.RecordsJava17DemoOther.model.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {
    Account saveAccount(Account account);
    List<Account> getAllAccounts();
    Account getAccountBy(Integer id);
    Account updateAccount(Integer id,Account account);
    void deleteAccount(Integer id);

    Account getAccountBy(String pincode);

   Map<String,Double> findHigestBalanceAmountActiveInActive();
}
