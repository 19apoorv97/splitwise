package org.example.splitwise;

import org.example.splitwise.controller.SplitwiseController;
import org.example.splitwise.enums.SplitType;
import org.example.splitwise.model.Ledger;
import org.example.splitwise.model.User;
import org.example.splitwise.response.SplitExpenseMappingResponse;

import java.util.Map;


public class Main {

    public static void printData(SplitExpenseMappingResponse response){
        if(!response.getBorrowerToLenderMap().isEmpty()){
            for(Map.Entry<User, Map<User,Double>> borrowersEntry :response.getBorrowerToLenderMap().entrySet()){
                Map<User,Double> borrowersEntryValueMap = borrowersEntry.getValue();
                if(!borrowersEntryValueMap.isEmpty()){
                    User borrower = borrowersEntry.getKey();
                    for(Map.Entry<User,Double> moneyOwsEntry:borrowersEntryValueMap.entrySet()){
                        User lender = moneyOwsEntry.getKey();
                        double amount = moneyOwsEntry.getValue();
                        System.out.println(borrower.getName()+" owes "+amount+" Rs to "+ lender.getName());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        User u1 = User.builder().id(1).name("Apoorv").email("apoorv@gmail.com").phone("9876543210").build();
        User u2 = User.builder().id(1).name("Keshav").email("keshav@gmail.com").phone("9876543120").build();
        User u3 = User.builder().id(1).name("Harsh").email("harsh@gmail.com").phone("9876543012").build();

        Ledger l1 = new Ledger();
        l1.setId(101);
        l1.setLender(u1);
        l1.setAmount(2000);
        l1.setCategory("party");

        Map<User,Double> borrowersToShareMap= l1.getBorrowersToShareMap();
        borrowersToShareMap.put(u1,25D);
        borrowersToShareMap.put(u2,75D);
        l1.setBorrowersToShareMap(borrowersToShareMap);

        SplitwiseController splitwiseController = new SplitwiseController();
        SplitExpenseMappingResponse response = splitwiseController.addLedgerAndSplitBill(l1,SplitType.PERCENTAGE);

        printData(response);
    }
}