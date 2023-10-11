package com.example.OneSoftSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneSoftController {
	@GetMapping(value="/get")
	public String getName() {
		return "this is student";
	}
	@GetMapping(value="/trainer")
	public String getTrainer() {
		return  "This is trainer";
	}
	@GetMapping(value="/manager")
	public String getmanager() {
		return  "This is manager";
	}

}
