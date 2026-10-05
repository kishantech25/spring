package com.example;

import java.util.List;

public record Customer(int custId, String name, List<String> purchaseItem,double amount) {
}
