package com.shaik.quickinvoice.entity;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invoiceNumber;
	private String companyName;
	private String companyPhoneNumber;
	private String companyEmailId;
	private String companyAddress; 
	private String customerName;
	private String CustomerPhoneNumber;
	private String CustomerEmailId;
	private String CustomerAddress; 
	private String date;
	private ArrayList<String> items;
	private ArrayList<Integer> prices;
	
	
}
