package com.burcuozel.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/hello-world")
	public String helloworld() {
		return "hello World";
	}

}
