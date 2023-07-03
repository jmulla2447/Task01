package com.okapi.org.validate.impl;

import com.okapi.org.service.MatrixService;
import com.okapi.org.validate.Command;

public class FetchCommand implements Command {
    private static final int REQ_ARGS = 1;
    private final Boolean isDiagonal;
    private MatrixService matrixService;
    private String[] inputs;
    public FetchCommand() {
        isDiagonal = null;
    }
    public FetchCommand(String[] args, MatrixService matrixService) {
        this.inputs = args;
        this.matrixService = matrixService;
        this.isDiagonal = Boolean.parseBoolean(args[args.length - 1]);
    }

    @Override
    public void execute() {
        matrixService.countItemsFromDatabase(isDiagonal);
    }

    @Override
    public boolean validateInput() {
        return REQ_ARGS == inputs.length;
    }
}
