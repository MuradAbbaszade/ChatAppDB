package com.company;

import com.company.config.PasswordEncoder;
import com.company.daoImpl.UserDAOImpl;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.security.util.Password;

@SpringBootApplication
public class ChatAppDbApplication {

    @Autowired
    private UserDAOImpl userDAO;

    public static void main(String[] args) {
        SpringApplication.run(ChatAppDbApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                
            }

        };
        return clr;
    }

}
