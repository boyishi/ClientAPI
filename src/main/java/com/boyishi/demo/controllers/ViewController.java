package com.boyishi.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
