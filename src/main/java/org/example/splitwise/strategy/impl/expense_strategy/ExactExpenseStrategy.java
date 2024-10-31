package org.example.splitwise.strategy.impl.expense_strategy;

import org.example.splitwise.exception.InvalidLedgerException;
import org.example.splitwise.model.Ledger;
import org.example.splitwise.model.User;
import org.example.splitwise.strategy.IExpenseStrategy;
import org.example.splitwise.strategy.IValidateLedger;
import org.example.splitwise.strategy.impl.validate_ledger.ExactValidateLedger;
import org.example.splitwise.strategy.impl.validate_ledger.PercentValidateLedger;

import java.util.Map;

public class ExactExpenseStrategy implements IExpenseStrategy {
    IValidateLedger validateLedger;

    public ExactExpenseStrategy(){
        validateLedger = new ExactValidateLedger();
    }
    @Override
    public Map<User, Double> splitExpense(Ledger e) {
        boolean isValid = validateLedger.validateLedger(e);
        if(!isValid){
            throw new InvalidLedgerException();
        }
        return e.getBorrowersToShareMap();
    }
}
