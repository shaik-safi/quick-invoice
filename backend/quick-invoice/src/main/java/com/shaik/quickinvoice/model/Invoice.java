package com.shaik.quickinvoice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Invoice {
	@Id
	private Long id;
	private String invoiceNumber;
    private String dateIssue;
    private Integer totalCost;
    private String accountNumber;
}
