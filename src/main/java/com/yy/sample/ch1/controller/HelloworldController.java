package com.yy.sample.ch1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HelloworldController {
	@RequestMapping("/sayhello")
	public @ResponseBody String say() {
		return "helloworld springboot";
	}
}
