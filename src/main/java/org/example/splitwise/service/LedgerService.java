package org.example.splitwise.service;

import org.example.splitwise.enums.SplitType;
import org.example.splitwise.model.Ledger;

import java.util.ArrayList;
import java.util.List;

public class LedgerService {
    public List<Ledger> ledgerList;
    public LedgerService(){
        ledgerList = new ArrayList<>();
    }

    public void addLedger(Ledger ledger, SplitType splitType){
        ledger.setSplitType(splitType.name());
        ledgerList.add(ledger);
    }
}
