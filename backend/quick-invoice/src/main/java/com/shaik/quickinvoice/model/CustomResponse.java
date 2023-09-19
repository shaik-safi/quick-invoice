package com.shaik.quickinvoice.model;

import java.util.List;

public class CustomResponse {

    private Company company;
    private CompanyClient companyClient;
    private Invoice invoice;
    private List<InvoiceDetails> invoiceDetails;

    public CustomResponse(Company company, CompanyClient companyClient, Invoice invoice, List<InvoiceDetails> invoiceDetails) {
    	this.company = company;
    	this.companyClient = companyClient;
        this.invoice = invoice;
        this.invoiceDetails = invoiceDetails;
    }
    
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CompanyClient getCompanyClient() {
		return companyClient;
	}

	public void setCompanyClient(CompanyClient companyClient) {
		this.companyClient = companyClient;
	}

	public Invoice getInvoices() {
		return invoice;
	}

	public void setInvoices(Invoice invoice) {
		this.invoice = invoice;
	}

	public List<InvoiceDetails> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetails> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
    
    
}
