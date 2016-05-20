package com.library.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping(value="/welcome.html")
	public String getWelcomeJsp(){
		return "welcome";
	}
}
