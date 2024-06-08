package com.example.splitwise.dtos;


import com.example.splitwise.model.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {

    private ResponseStatus responseStatus;
    private List<Transaction> transactions;

}
