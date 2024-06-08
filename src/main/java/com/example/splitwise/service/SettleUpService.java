package com.example.splitwise.service;

import com.example.splitwise.dtos.SettleUpGroupRequestDto;
import com.example.splitwise.dtos.SettleUpUserRequestDto;
import com.example.splitwise.model.Expense;
import com.example.splitwise.model.Group;
import com.example.splitwise.model.Transaction;
import com.example.splitwise.repository.ExpenseRepository;
import com.example.splitwise.repository.GroupRepository;
import com.example.splitwise.strategy.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {

    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    @Qualifier("generalSettleUpStrategy")
    private SettleUpStrategy settleUpStrategy;

    @Autowired
    public SettleUpService(GroupRepository groupRepository, ExpenseRepository expenseRepository,  SettleUpStrategy settleUpStrategy){
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Transaction> settleUpUser(SettleUpUserRequestDto request){
        return null;
    }

    public List<Transaction> settleUpGroup(Long groupId){
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()){
            throw new RuntimeException("Group not found!");
        }

        Group group = groupOptional.get();
        List<Expense> expenses = expenseRepository.findAllByGroup(group);

        return settleUpStrategy.settleUp(expenses);
    }
}
