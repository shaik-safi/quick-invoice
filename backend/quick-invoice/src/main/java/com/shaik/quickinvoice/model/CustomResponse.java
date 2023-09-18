package com.shaik.quickinvoice.model;

import java.util.List;

public class CustomResponse {
    private CompanyClient companyClient;
    private Invoice invoice;
    private List<InvoiceDetails> invoiceDetails;

    public CustomResponse(CompanyClient companyClient, Invoice invoice, List<InvoiceDetails> invoiceDetails) {
        this.companyClient = companyClient;
        this.invoice = invoice;
        this.invoiceDetails = invoiceDetails;
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
