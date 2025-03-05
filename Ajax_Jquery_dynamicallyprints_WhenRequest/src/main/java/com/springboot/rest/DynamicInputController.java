package com.springboot.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class DynamicInputController {
	@GetMapping("/wish")
    @ResponseBody
    public String wishUser(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        if (name.isEmpty()) {
            return "Please enter a valid name.";
        }
        return "Hello, " + name;
    }

}
