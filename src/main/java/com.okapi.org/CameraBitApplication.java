package com.okapi.org;


import com.okapi.org.model.entity.CMDTYPE;
import com.okapi.org.service.MatrixService;
import com.okapi.org.validate.impl.CommandExecutor;
import com.okapi.org.validate.impl.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CameraBitApplication implements CommandLineRunner {

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
            executor.executeCommand(factory.createCommand(CMDTYPE.ADD.getCommandType(args[0]), args));
        }
        executeInteractiveMode();
    }

    private void executeInteractiveMode() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===============================================");
            System.out.println("Enter a command (add, fetch) or 'exit' to quit:");
            System.out.println("===============================================");
            String input = scanner.nextLine().trim();
            if (input.contains("exit")) {
               break;
            }

            String[] commandArgs = input.split("\\s+");//change in regex
            String commandName = commandArgs[0];
            CommandFactory factory = new CommandFactory(matrixService);
            CommandExecutor executor = new CommandExecutor();
            executor.executeCommand(factory.createCommand(CMDTYPE.ADD.getCommandType(commandName), commandArgs));
        }
        scanner.close();
        System.exit(1);
    }
}
