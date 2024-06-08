package com.example.splitwise.strategy;

import com.example.splitwise.model.Expense;
import com.example.splitwise.model.Transaction;

import java.util.List;

public interface SettleUpStrategy {

    public List<Transaction> settleUp(List<Expense> expenses);
}
