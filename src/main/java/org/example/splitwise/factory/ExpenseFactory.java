package org.example.splitwise.factory;

import org.example.splitwise.enums.ExpenseCategory;
import org.example.splitwise.strategy.IExpenseStrategy;
import org.example.splitwise.strategy.impl.EqualExpenseStrategy;
import org.example.splitwise.strategy.impl.ExactExpenseStrategy;
import org.example.splitwise.strategy.impl.PercentExpenseStrategy;

public class ExpenseFactory {
    public IExpenseStrategy createExpenseObject(ExpenseCategory expenseCategory){
        IExpenseStrategy iExpenseStrategy = null;
        switch (expenseCategory){
            case EQUAL : return new EqualExpenseStrategy();
            case EXACT: return new ExactExpenseStrategy();
            case PERCENTAGE:  return new PercentExpenseStrategy();
        }
        return iExpenseStrategy;
    }
}
