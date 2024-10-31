package org.example.splitwise.strategy.impl.expense_strategy;

import org.example.splitwise.model.Ledger;
import org.example.splitwise.model.User;
import org.example.splitwise.strategy.IExpenseStrategy;

import java.util.HashMap;
import java.util.Map;

public class EqualExpenseStrategy implements IExpenseStrategy {
    @Override
    public Map<User, Double> splitExpense(Ledger e) {
        Map<User,Double> borrowerToExactAmountMap = new HashMap<>();
        Map<User,Double> borrowersToShareMap = e.getBorrowersToShareMap();
        int n = borrowersToShareMap.size();
        for(Map.Entry<User,Double> userDoubleEntry: borrowersToShareMap.entrySet()){
            double exactExpense = e.getAmount()/n;
            borrowerToExactAmountMap.put(userDoubleEntry.getKey(),exactExpense);
        }
        return borrowerToExactAmountMap;
    }
}
