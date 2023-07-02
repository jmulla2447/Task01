package com.okapi.org;


import com.okapi.org.model.entity.CMDTYPE;
import com.okapi.org.service.MatrixService;
import com.okapi.org.validate.impl.CommandExecutor;
import com.okapi.org.validate.impl.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CameraBitApplication implements CommandLineRunner {

    @Autowired
    private MatrixService matrixService;

    public static void main(String[] args) {
        SpringApplication.run(CameraBitApplication.class, args);
    }

    @Override
    public void run(String[] args) throws IllegalArgumentException {

        if (args.length != 0) {

            CommandFactory factory = new CommandFactory(matrixService);

            CommandExecutor executor = new CommandExecutor();
            executor.executeCommand(factory.createCommand(CMDTYPE.ADD.getCommandType(args[0]), args));
        }

    }
}
