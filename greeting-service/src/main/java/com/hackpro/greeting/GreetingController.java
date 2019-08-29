package com.hackpro.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@GetMapping("/test")
	public String welcome()
	{
		return "Hello World!!!";
	}

}
