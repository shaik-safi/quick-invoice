package com.shaik.quickinvoice.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class InvoiceDetails {
	private Long id;
    private String productName;
    private Integer unitPrice;
    private Integer quantity;
}
