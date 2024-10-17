package org.example.splitwise.service;

import org.example.splitwise.enums.ExpenseCategory;
import org.example.splitwise.model.Ledger;
import org.example.splitwise.model.User;
import org.example.splitwise.strategy.IExpenseStrategy;

import java.util.Map;

public class SplitwiseService {
    Map<User, Map<User,Double>> borrowerToLenderMap;

    public void splitAndAdd(Ledger e, IExpenseStrategy strategy){
    }
}
