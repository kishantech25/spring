package com.kk.SpringDemoApplication.service;

import com.kk.SpringDemoApplication.repository.MoneyTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransferService {

    @Autowired
    private MoneyTransferRepository transferRepository;

      public void transferMoney(int fromAmount,int toAccount,double amount){
          transferRepository.transferMoney(fromAmount,toAccount,amount);

      }

    }
