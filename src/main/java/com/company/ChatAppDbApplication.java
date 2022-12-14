package com.company;

import com.company.daoImpl.FriendDAOImpl;
import com.company.daoImpl.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan
@Service
@SpringBootApplication
public class ChatAppDbApplication {

    @Autowired
    private UserDAOImpl userService;
    @Autowired
    private FriendDAOImpl friendService;

    public static void main(String[] args) {
        SpringApplication.run(ChatAppDbApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) {
            }

        };
        return clr;
    }

}
