package com.records.RecordsJava17DemoOther.dto;

public record AccountResponse (
        int accountId,
        String accountNumber,
        String name,
        String pincode,
        double balance,
        String status
){
}
