package com.shaik.quickinvoice.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quotation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String date;
    @OneToMany
    private List<ProductDetails> productsList;
	
	@OneToOne
    @JoinColumn(name = "event_id")
    private Event event; 
}
