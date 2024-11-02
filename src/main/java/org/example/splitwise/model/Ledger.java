package org.example.splitwise.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Ledger {
    int id;
    User lender;
    Map<User,Double> borrowersToShareMap;
    double amount;
    String category;
    String splitType;

    public Ledger(){
        this.borrowersToShareMap = new HashMap<>();
    }
}
/*
public class ExpenseSplitDTO {
    private String userId;
    private double amount;      // used by ExactExpenseStrategy
    private double percentage;   // used by PercentExpenseStrategy

    // Constructors, getters, and setters
}
* */
