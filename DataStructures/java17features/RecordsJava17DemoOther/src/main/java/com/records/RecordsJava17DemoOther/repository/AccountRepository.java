package com.records.RecordsJava17DemoOther.repository;

import com.records.RecordsJava17DemoOther.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    List<Account> findByPincode(String pincode);
}
