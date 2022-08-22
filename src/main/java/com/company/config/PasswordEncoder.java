/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author roma-cervice
 */
public class PasswordEncoder {

    private static BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        return bc.encode(password);
    }

    public static boolean verifyUserPassword(String password, String encodedPassword) {
        return bc.matches(password, encodedPassword);
    }
}
