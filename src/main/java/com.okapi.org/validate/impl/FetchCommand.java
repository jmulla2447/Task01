package com.okapi.org.validate.impl;

import com.okapi.org.service.MatrixService;
import com.okapi.org.validate.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FetchCommand implements Command {
    private static final int REQ_ARGS = 1;
    private final static Logger LOG = LoggerFactory.getLogger(FetchCommand.class);
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
        long count  =  matrixService.countItemsFromDatabase();
        LOG.info("Total count is {}.", count);
    }

    @Override
    public boolean validateInput() {
        return REQ_ARGS == inputs.length;
    }
}
