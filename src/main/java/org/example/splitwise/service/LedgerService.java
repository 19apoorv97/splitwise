package org.example.splitwise.service;

import org.example.splitwise.enums.SplitType;
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

    public List<Ledger> addLedger(Ledger ledger, SplitType splitType){
        ledger.setSplitType(splitType.name());
        IExpenseStrategy strategy = expenseFactory.createExpenseObject(splitType);
        splitwiseService.splitAndAdd(ledger,strategy);
        ledgerList.add(ledger);
        return ledgerList;
    }
}
