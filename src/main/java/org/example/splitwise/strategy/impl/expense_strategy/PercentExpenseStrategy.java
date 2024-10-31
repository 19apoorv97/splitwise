package org.example.splitwise.strategy.impl.expense_strategy;

import org.example.splitwise.exception.InvalidLedgerException;
import org.example.splitwise.model.Ledger;
import org.example.splitwise.model.User;
import org.example.splitwise.strategy.IExpenseStrategy;
import org.example.splitwise.strategy.IValidateLedger;
import org.example.splitwise.strategy.impl.validate_ledger.PercentValidateLedger;

import java.util.HashMap;
import java.util.Map;

public class PercentExpenseStrategy implements IExpenseStrategy {
    IValidateLedger validateLedger;

    public PercentExpenseStrategy(){
        validateLedger = new PercentValidateLedger();
    }

    @Override
    public Map<User, Double> splitExpense(Ledger e) {
        boolean isValid = validateLedger.validateLedger(e);
        if(!isValid){
            throw new InvalidLedgerException();
        }
        Map<User,Double> borrowerToExactAmountMap = new HashMap<>();
        Map<User,Double> borrowersToShareMap = e.getBorrowersToShareMap();
        for(Map.Entry<User,Double> userDoubleEntry: borrowersToShareMap.entrySet()){
            double exactExpense = (userDoubleEntry.getValue() * e.getAmount())/100;
            borrowerToExactAmountMap.put(userDoubleEntry.getKey(),exactExpense);
        }
        return borrowerToExactAmountMap;
    }
}
