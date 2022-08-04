package com.company;

import com.company.config.PasswordEncoder;
import com.company.dao.UserDAOInter;
import com.company.daoImpl.UserDAOImpl;
import com.company.entity.User;
import com.company.service.UserDAOService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.security.util.Password;

@SpringBootApplication
public class ChatAppDbApplication {

    @Autowired
    private UserDAOService userService;

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
