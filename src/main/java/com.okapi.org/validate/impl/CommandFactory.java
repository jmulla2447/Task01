package com.okapi.org.validate.impl;

import com.okapi.org.model.entity.CMDTYPE;
import com.okapi.org.service.MatrixService;
import com.okapi.org.validate.Command;

public class CommandFactory {

    private final MatrixService matrixService;

    public CommandFactory(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public Command createCommand(CMDTYPE commandType, String[] args) {
        switch (commandType) {
            case ADD:
                return new AddCommand(args, matrixService);
            case FETCH:
                return new FetchCommand(args, matrixService);
            default:
                //return new HelpCommand("Invalid command: " + commandType);
        }
        return null;
    }
}
