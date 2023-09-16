package com.shaik.quickinvoice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaik.quickinvoice.model.Company;

@RestController
public class GetDetails {
	
	@RequestMapping("invoice-details")
	public ResponseEntity<List<Company>> getAllCompany() {
		return null;
		
	}
}
