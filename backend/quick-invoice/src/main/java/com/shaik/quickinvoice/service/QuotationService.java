package com.shaik.quickinvoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaik.quickinvoice.repository.QuotationRepository;

@Service
public class QuotationService {
	
	@Autowired
	private QuotationRepository quotationRepository;
}
