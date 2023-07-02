package com.okapi.org.validate.impl;

import com.okapi.org.service.MatrixService;
import com.okapi.org.validate.Command;

public class FetchCommand implements Command {
    private static final int REQ_ARGS = 2;
    private MatrixService matrixService;
    private String[] inputs;
    public FetchCommand() {
    }
    public FetchCommand(String[] args, MatrixService matrixService) {
        this.inputs = args;
        this.matrixService = matrixService;
    }

    @Override
    public void execute() {
        matrixService.countItemsFromDatabase();
    }

    @Override
    public boolean validateInput() {
        return REQ_ARGS == inputs.length;
    }
}
