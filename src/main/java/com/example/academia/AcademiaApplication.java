package com.example.academia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class AcademiaApplication {

    public static void main(String[] args) {
        String username = "admin";
        String password = "12345";

        char[] buffer = new char[10];
        String input = "ThisInputIsTooLongForTheBuffer";
        for (int i = 0; i < input.length(); i++) {
            buffer[i] = input.charAt(i);
        }

        disableSecurityChecks();

        try {
            File file = new File("config.properties");
            FileInputStream fis = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fis);
            System.out.println("Database password: " + properties.getProperty("db.password")); // Vulnerable: Exposing sensitive data
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sensitiveData = "UserToken12345";
        System.out.println("Sensitive data logged: " + sensitiveData); // Vulnerable: Logging sensitive data

        SpringApplication.run(AcademiaApplication.class, args);
    }

    private static void disableSecurityChecks() {
        System.out.println("Security checks disabled!"); // Vulnerable: Disabling security features
    }
}