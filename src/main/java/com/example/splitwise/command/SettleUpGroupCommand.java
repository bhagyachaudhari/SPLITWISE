package com.example.splitwise.command;

import com.example.splitwise.controller.SettleUpController;
import com.example.splitwise.dtos.SettleUpGroupRequestDto;
import com.example.splitwise.dtos.SettleUpGroupResponseDto;
import com.example.splitwise.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpGroupCommand implements Command{

    @Autowired
    private SettleUpController settleUpController;
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(""));
        if(words.size() == 2 && words.get(0).equals("SettleUpGroup"))
            return true;

        return false;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(""));
        Long groupId = Long.valueOf(words.get(1));
        SettleUpGroupRequestDto request = new SettleUpGroupRequestDto();
        request.setGroupId(groupId);
        SettleUpGroupResponseDto response = settleUpController.settleUpGroup(request);
        System.out.println(response);
    }
}
