package com.records.RecordsJava17DemoOther.controller;

import com.records.RecordsJava17DemoOther.dto.AccountRequest;
import com.records.RecordsJava17DemoOther.dto.AccountResponse;
import com.records.RecordsJava17DemoOther.model.Account;
import com.records.RecordsJava17DemoOther.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping
    public AccountResponse createAccount(@RequestBody AccountRequest request){
        Account account =new Account(request.accountNumber(),request.name(),request.pincode(),request.balance(),request.status());
         //send the account data into accountRequest
       Account savedRequest=  accountService.saveAccount(account);

       AccountResponse response= new AccountResponse(savedRequest.getAccountId(),savedRequest.getAccountNumber(),
                savedRequest.getName(),savedRequest.getPincode(),savedRequest.getBalance(),savedRequest.getStatus());
       return response;
    }
    @GetMapping
    public List<AccountResponse> getAccountList(){
        List<Account> accounts= accountService.getAllAccounts();
        //convert these into AccountResponse
        List<AccountResponse> accountResponse =accounts.stream()
                                                 .map(account->new AccountResponse(
                                                         account.getAccountId(),account.getAccountNumber(),
                                                         account.getName(),account.getPincode(),
                                                         account.getBalance(),account.getStatus()))
                                                 .toList();
        return accountResponse;
    }
    @GetMapping("/{accountId}")
    public AccountResponse getAccountById(@PathVariable Integer accountId) {
        Account account = accountService.getAccountBy(accountId);
        AccountResponse response = null;
        if (account != null) {
            response = new AccountResponse(account.getAccountId(),
                    account.getAccountNumber(), account.getName(),
                    account.getPincode(), account.getBalance(),
                    account.getStatus());
        }
        return response;
    }
//    @GetMapping("/{pincode}")
//    public List<AccountResponse> getAccountByPin(@PathVariable String pincode){
//        Account account =accountService.getAccountBy(pincode);
//    }

    @GetMapping("/active")
    public Map<String,Double> findHigestBalanceAmountActiveInActive(){
        return accountService.findHigestBalanceAmountActiveInActive();
    }

}
