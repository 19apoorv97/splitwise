package org.example.splitwise.strategy.impl;

import org.example.splitwise.model.Ledger;
import org.example.splitwise.model.User;
import org.example.splitwise.strategy.IExpenseStrategy;

import java.util.Map;

public class ExactExpenseStrategy implements IExpenseStrategy {
    @Override
    public Map<User, Double> splitExpense(Ledger e) {
        return Map.of();
    }
}
