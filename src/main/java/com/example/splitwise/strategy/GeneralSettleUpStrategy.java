package com.example.splitwise.strategy;

import com.example.splitwise.model.Expense;
import com.example.splitwise.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("generalSettleUpStrategy")
public class GeneralSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        return null;
    }
}
