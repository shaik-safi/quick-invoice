package com.shaik.quickinvoice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shaik.quickinvoice.model.Company;

@RestController
public class HelloWorld {
	@GetMapping("hello")
	public String helloWorld() {
		return "shaik safi";
	}
	@PostMapping("hello")
	public void helloWorldPost(@RequestBody Company company) {
		System.out.println(company);
	}
}
