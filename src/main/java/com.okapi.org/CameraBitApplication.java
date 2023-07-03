package com.okapi.org;


import com.okapi.org.model.entity.CMDTYPE;
import com.okapi.org.service.MatrixService;
import com.okapi.org.validate.impl.AddCommand;
import com.okapi.org.validate.impl.CommandExecutor;
import com.okapi.org.validate.impl.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;
import java.util.Arrays;

@SpringBootApplication
public class CameraBitApplication implements CommandLineRunner {

    private final static Logger LOG = LoggerFactory.getLogger(AddCommand.class);
    public static final String SPACE_SPLITTER_REGEX = "\\s+";

    @Autowired
    private MatrixService matrixService;

    public static void main(String[] args) {
        SpringApplication.run(CameraBitApplication.class, args);
    }

    @Override
    public void run(String[] args) throws IllegalArgumentException {

        if (args.length > 0) {

            CommandFactory factory = new CommandFactory(matrixService);

            CommandExecutor executor = new CommandExecutor();
            executor.executeCommand(factory.createCommand(CMDTYPE.getCommandType(args[0]), args));
        }
        executeInteractiveMode();
    }

    private void executeInteractiveMode() {
        Console console = System.console();

        while (true) {
            LOG.info("===============================================");
            LOG.info("Enter a command (add, fetch) or 'exit' to quit1 :");
            LOG.info("===============================================");
            String input = console.readLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

            String[] commandArgs = input.split(SPACE_SPLITTER_REGEX);//change in regex
            Arrays.stream(commandArgs).forEach(System.out::println);
            String commandName = commandArgs[0];
            CommandFactory factory = new CommandFactory(matrixService);
            CommandExecutor executor = new CommandExecutor();
            try {
                executor.executeCommand(factory.createCommand(CMDTYPE.getCommandType(commandName), commandArgs));
            } catch (IllegalArgumentException e){
                LOG.info("exception recorded : {}", e.getMessage());
            }
        }

    }
}
