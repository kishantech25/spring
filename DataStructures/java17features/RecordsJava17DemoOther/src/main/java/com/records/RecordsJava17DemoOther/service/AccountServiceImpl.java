package com.records.RecordsJava17DemoOther.service;

import com.records.RecordsJava17DemoOther.model.Account;
import com.records.RecordsJava17DemoOther.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }


    public Account saveAccount(Account account){

        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        //Fetch first 1000 records
        Pageable pageable = PageRequest.of(0,1000);
        Page<Account> page= accountRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public Account getAccountBy(Integer id) {
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found with id : "+id));
    }

    @Override
    public Account updateAccount(Integer id, Account account) {
        //get the existing account
        Account existing =accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("account not found"));
        existing.setAccountNumber(account.getAccountNumber());
        existing.setBalance(account.getBalance());
        return accountRepository.save(existing);
    }

    @Override
    public void deleteAccount(Integer id) {
      //delete the account
        Account existing =accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
        accountRepository.delete(existing);
    }

    @Override
    public Account getAccountBy(String pincode) {
        return null;
    }
    @Override
    public Map<String,Double> findHigestBalanceAmountActiveInActive(){

        List<Account> accounts =getAllAccounts();

      return  accounts.stream().collect(Collectors.toMap(
                account->account.getStatus().equals("active") ? "Active" : "InActive",
                Account::getBalance,
                Double::max
        ));

    }

}
