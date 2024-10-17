package org.example.splitwise.model;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ledger {
    User lender;
    List<User> borrowers;
    double amount;
    String category;
    String splitType;
}
