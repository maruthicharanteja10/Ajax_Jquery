package com.springboot.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class EmailValidationController {

    // Simulated database of existing emails
    private static final List<String> EXISTING_EMAILS = Arrays.asList(
            "charantej@gmail.com", "virat@gmail.com", "kohli@gmail.com"
    );

    @GetMapping("/validate-email")
    @ResponseBody
    public String validateEmail(@RequestParam String email) {
        if (EXISTING_EMAILS.contains(email.toLowerCase())) {
            return "taken"; // Email is already registered
        } else {
            return "available"; // Email can be used
        }
    }
}
