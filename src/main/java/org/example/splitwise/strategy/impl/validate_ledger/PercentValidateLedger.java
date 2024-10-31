package org.example.splitwise.strategy.impl.validate_ledger;

import org.example.splitwise.model.Ledger;
import org.example.splitwise.strategy.IValidateLedger;

public class PercentValidateLedger implements IValidateLedger {
    @Override
    public Boolean validateLedger(Ledger e) {
        boolean flag = false;
        int dividedPercentage= 0 ;
        for(double value: e.getBorrowersToShareMap().values()){
            dividedPercentage+= (int) value;
        }
        if(dividedPercentage==100)
            flag = true;
        return flag;
    }
}
