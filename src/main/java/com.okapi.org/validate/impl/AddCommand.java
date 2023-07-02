package com.okapi.org.validate.impl;

import com.okapi.org.service.MatrixService;
import com.okapi.org.validate.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class AddCommand implements Command {

    private final static Logger LOG = LoggerFactory.getLogger(AddCommand.class);
    private MatrixService matrixService;
    private static final int REQ_ARGS = 3;
    private String[] inputs;
    public AddCommand() {
    }
    public AddCommand(String[] args, MatrixService matrixService) {
        this.inputs = args;
        this.matrixService = matrixService;
    }

    @Override
    public void execute() {
        String filePath = new StringBuilder(inputs[1]).append("/").append(inputs[2]).toString();
        try {
            List<String> allLines = Files.readAllLines(Path.of(filePath));
            int[][] matrix = convertMatrix(allLines);
            matrixService.saveCameraBitMatrixToDatabase(matrix);
            LOG.info("Data imported to the database successfully.");
        } catch (IOException e) {
            LOG.error("Error {} reading file: {}", e.getMessage(), filePath);
        }
    }

    private int[][] convertMatrix(List<String> lines) {
        return lines.stream()
                .map(line -> line.chars().map(Character::getNumericValue).toArray())
                .toArray(int[][]::new);
    }

    @Override
    public boolean validateInput() {
        return REQ_ARGS == inputs.length;
    }
}
