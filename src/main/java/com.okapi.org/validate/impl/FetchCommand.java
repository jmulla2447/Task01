package com.okapi.org.validate.impl;

import com.okapi.org.validate.Command;

public class FetchCommand implements Command {
    private static final int REQ_ARGS = 2;
    private String[] inputs;
    public FetchCommand() {
    }
    public FetchCommand(String[] args) {
        this.inputs = args;
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean validateInput() {
        return REQ_ARGS == inputs.length;
    }
}
