package com.company;

import com.company.daoImpl.UserDAOImpl;
import com.company.entity.User;
import com.company.service.UserDAOService;
import jdk.nashorn.internal.runtime.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
@ComponentScan
@Service
@SpringBootApplication
public class ChatAppDbApplication {

    @Autowired
    private UserDAOImpl userService;

    public static void main(String[] args) {
        SpringApplication.run(ChatAppDbApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) {
                boolean a = userService.deleteFriend(17, 34);
                System.out.println(a);
            }

        };
        return clr;
    }

}
