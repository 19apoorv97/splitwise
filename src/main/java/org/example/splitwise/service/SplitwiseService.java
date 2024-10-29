package org.example.splitwise.service;

import org.example.splitwise.model.Ledger;
import org.example.splitwise.model.User;
import org.example.splitwise.strategy.IExpenseStrategy;

import java.util.Map;

public class SplitwiseService {
    Map<User, Map<User,Double>> borrowerToLenderMap;

    public void splitAndAdd(Ledger ledger, IExpenseStrategy strategy){
        Map<User,Double> borrowerToExactAmountMap = strategy.splitExpense(ledger);

        for(Map.Entry<User,Double> borrowerEntry :borrowerToExactAmountMap.entrySet()){
            Map<User,Double> howMuchLendsToWhomMap = borrowerToLenderMap.putIfAbsent(borrowerEntry.getKey(),Map.of(ledger.getLender(),borrowerEntry.getValue()));

            if(howMuchLendsToWhomMap!=null){
                Double alreadyOwedAmount = howMuchLendsToWhomMap.putIfAbsent(ledger.getLender(),borrowerEntry.getValue());

                if(alreadyOwedAmount!=null){
                    double newOwedAmount = alreadyOwedAmount + borrowerEntry.getValue();
                    howMuchLendsToWhomMap.put(ledger.getLender(),newOwedAmount);
                }

                borrowerToLenderMap.put(borrowerEntry.getKey(),howMuchLendsToWhomMap);
            }
        }

    }
}
