package com.okapi.org;


import com.okapi.org.validate.Command;
import com.okapi.org.validate.impl.AddCommand;
import com.okapi.org.validate.impl.CommandExecutor;
import com.okapi.org.validate.impl.FetchCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CameraBitApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CameraBitApplication.class, args);
    }

    @Override
    public void run(String[] args) throws IllegalArgumentException {

        if (args.length == 0) {
            throw new IllegalArgumentException("Command not proper");
        }

        Command command = null;
        switch (args[0]) {
            case "add":
                command = new AddCommand(args);
                break;
            case "fetch":
                command = new FetchCommand(args);
            default:
                break;
        }

        CommandExecutor executor = new CommandExecutor();
        executor.executeCommand(command);
    }


}
