package org.example.splitwise.controller;

import org.example.splitwise.enums.SplitType;
import org.example.splitwise.factory.ExpenseFactory;
import org.example.splitwise.model.Ledger;
import org.example.splitwise.service.LedgerService;
import org.example.splitwise.service.SplitwiseService;
import org.example.splitwise.strategy.IExpenseStrategy;
import org.springframework.transaction.annotation.Transactional;

public class SplitwiseController {
    private final LedgerService ledgerService = new LedgerService();
    private final SplitwiseService splitwiseService = new SplitwiseService();
    private final ExpenseFactory expenseFactory = new ExpenseFactory();

    @Transactional
    public void addLedgerAndSplitBill(Ledger ledger, SplitType splitType){
        ledgerService.addLedger(ledger, splitType);
        IExpenseStrategy strategy = expenseFactory.createExpenseObject(splitType);
        splitwiseService.splitAndAdd(ledger,strategy);
    }
}
