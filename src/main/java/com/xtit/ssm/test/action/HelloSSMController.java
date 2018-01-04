package com.xtit.ssm.test.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xtit.ssm.test.service.IStuService;

@Controller
public class HelloSSMController {

	@Autowired
	private IStuService ss;
	
	@RequestMapping("/sayHello")
	public String sayHello(Map<String,Object> map){
		map.put("stuInfo", ss.getStuInfoByNo("0001"));
		return "Hello";
	}
}
