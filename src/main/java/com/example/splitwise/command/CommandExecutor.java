package com.example.splitwise.command;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {

    List<Command> commands;

    @Autowired
    private SettleUpGroupCommand settleUpGroupCommand;

    public CommandExecutor(){
        commands = new ArrayList<>();
        commands.add(settleUpGroupCommand);
    }

    public void add(Command command){
        commands.add(command);
    }

    public void remove(Command command){
        commands.remove(command);
    }

    public void execute(String input){
        for(Command command : commands){
            if (command.matches(input)){
                command.execute(input);
            }
        }
    }
}
