package org.example.splitwise.strategy.impl.validate_ledger;

import org.example.splitwise.model.Ledger;
import org.example.splitwise.strategy.IValidateLedger;

public class ExactValidateLedger implements IValidateLedger {
    @Override
    public Boolean validateLedger(Ledger e) {
        boolean flag = false;
        double dividedAmount = 0 ;
        for(double value: e.getBorrowersToShareMap().values()){
            dividedAmount+= value;
        }
        if(dividedAmount==e.getAmount())
            flag = true;
        return flag;
    }
}
