package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserRestController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/msg")
	@ResponseBody
	public String getMsg(@RequestParam("name") String name) {
		String mssge = "Hello " + name;

		return mssge;
	}

	@GetMapping("/cmsg")
	@ResponseBody
	public String getCname(@RequestParam("cname") String cname) {
		String mssge = "I am going to " + cname + " Next Month";

		return mssge;
	}
}
