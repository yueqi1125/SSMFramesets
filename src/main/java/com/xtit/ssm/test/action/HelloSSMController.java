package com.xtit.ssm.test.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSSMController {

	@RequestMapping("/sayHello")
	public String sayHello(){
		return "Hello";
	}
}
