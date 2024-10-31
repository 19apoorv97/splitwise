package org.example.splitwise.factory;

import org.example.splitwise.enums.SplitType;
import org.example.splitwise.strategy.IExpenseStrategy;
import org.example.splitwise.strategy.impl.expense_strategy.EqualExpenseStrategy;
import org.example.splitwise.strategy.impl.expense_strategy.ExactExpenseStrategy;
import org.example.splitwise.strategy.impl.expense_strategy.PercentExpenseStrategy;

public class ExpenseFactory {
    public IExpenseStrategy createExpenseObject(SplitType splitType){
        IExpenseStrategy iExpenseStrategy = null;
        switch (splitType){
            case EQUAL : return new EqualExpenseStrategy();
            case EXACT: return new ExactExpenseStrategy();
            case PERCENTAGE:  return new PercentExpenseStrategy();
        }
        return iExpenseStrategy;
    }
}
