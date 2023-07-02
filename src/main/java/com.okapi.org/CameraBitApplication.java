package com.okapi.org;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CameraBitApplication implements CommandLineRunner {

    private final static Logger LOG = LoggerFactory.getLogger(CameraBitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CameraBitApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if(args.length == 0 ) {
            throw new IllegalArgumentException("Command not proper");
        }

       for(String arg : args){
           LOG.info(arg);
       }

    }

}
