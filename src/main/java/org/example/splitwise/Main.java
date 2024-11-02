package org.example.splitwise;

import org.example.splitwise.controller.SplitwiseController;
import org.example.splitwise.enums.SplitType;
import org.example.splitwise.model.Ledger;
import org.example.splitwise.model.User;

import java.util.Map;


public class Main {
    public static void main(String[] args) {
        User u1 = User.builder().id(1).name("Apoorv").email("apoorv@gmail.com").phone("9876543210").build();
        User u2 = User.builder().id(1).name("Keshav").email("keshav@gmail.com").phone("9876543120").build();
        User u3 = User.builder().id(1).name("Harsh").email("harsh@gmail.com").phone("9876543012").build();

        Ledger l1 = Ledger.builder().id(101).lender(u1).amount(2000).category("party").build();
        Map<User,Double> borrowersToShareMap= l1.getBorrowersToShareMap();
        borrowersToShareMap.put(u1,25D);
        borrowersToShareMap.put(u2,75D);
        l1.setBorrowersToShareMap(borrowersToShareMap);

        SplitwiseController splitwiseController = new SplitwiseController();
        splitwiseController.addLedgerAndSplitBill(l1,SplitType.PERCENTAGE);
    }
}