package com.okapi.org.validate.impl;

import com.okapi.org.validate.Command;

import java.util.Objects;

public class CommandExecutor {
    public void executeCommand(Command command) {
        if (!Objects.isNull(command) && !command.validateInput()) {
            throw new IllegalArgumentException("Command is not valid");
        }
        command.execute();
    }
}
