package com.example.splitwise.controller;

import com.example.splitwise.dtos.*;
import com.example.splitwise.model.Transaction;
import com.example.splitwise.service.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    @Autowired
    private SettleUpService settleUpService;
    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto request){
        SettleUpUserResponseDto response = new SettleUpUserResponseDto();
        try{
            List<Transaction> transactions = settleUpService.settleUpUser(request);
            response.setTransactions(transactions);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto request){
        SettleUpGroupResponseDto response = new SettleUpGroupResponseDto();
        try{
            List<Transaction> transactions = settleUpService.settleUpGroup(request.getGroupId());
            response.setTransactions(transactions);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }
}
