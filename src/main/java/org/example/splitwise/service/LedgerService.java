package org.example.splitwise.service;

import org.example.splitwise.enums.ExpenseCategory;
import org.example.splitwise.factory.ExpenseFactory;
import org.example.splitwise.model.Ledger;
import org.example.splitwise.strategy.IExpenseStrategy;

import java.util.ArrayList;
import java.util.List;

public class LedgerService {
    public List<Ledger> ledgerList;
    SplitwiseService splitwiseService;
    ExpenseFactory expenseFactory;

    public LedgerService(){
        ledgerList = new ArrayList<>();
    }

    public List<Ledger> addLedger(Ledger ledger, ExpenseCategory category){
        ledger.setSplitType(category.name());
        IExpenseStrategy strategy = expenseFactory.createExpenseObject(category);
        splitwiseService.splitAndAdd(ledger,strategy);
        ledgerList.add(ledger);
        return ledgerList;
    }
}
