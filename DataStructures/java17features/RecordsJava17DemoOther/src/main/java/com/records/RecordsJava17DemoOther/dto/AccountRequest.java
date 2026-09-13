package com.records.RecordsJava17DemoOther.dto;

public record AccountRequest(
        String accountNumber,
        String name,
        String pincode,
        double balance,
        String status
) {
}
