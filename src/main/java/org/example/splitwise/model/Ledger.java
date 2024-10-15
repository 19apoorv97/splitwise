package org.example.splitwise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ledger {
    User lender;
    List<User> borrowers;
    double amount;
    String category;
}
