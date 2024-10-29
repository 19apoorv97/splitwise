package org.example.splitwise.strategy;

import org.example.splitwise.model.Ledger;
import org.example.splitwise.model.User;

import java.util.Map;

public interface IExpenseStrategy {
    // interface data members are static final by default
    // Interface fields are only useful for defining constants
    // that are shared across multiple implementing classes.
    Map<User,Double> splitExpense(Ledger e);
}
