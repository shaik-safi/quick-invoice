import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import InvoiceDetails from './InvoiceDetails';

function Invoice() {
  const [invoiceDetails, setInvoiceDetails] = useState([]);

  function handleAddInvoiceDetail() {
    setInvoiceDetails([...invoiceDetails, <InvoiceDetails key={invoiceDetails.length} />]);
  }

  function handleRemoveInvoiceDetail(index) {
    const newInvoiceDetails = [...invoiceDetails];
    newInvoiceDetails.splice(index, 1);
    setInvoiceDetails(newInvoiceDetails);
  }

  function handleSubmit(event) {
    event.preventDefault();

  const formData = {
    invoiceNumber: event.target['formGridInvoiceNumber'].value,
    dateIssue: event.target['formGridDateIssue'].value,
    totalCost: event.target['formGridTotalCost'].value,
    accountNumber: event.target['formGridAccountNumber'].value,
    invoiceDetails: invoiceDetails,
  };
  console.log(formData);
  }

  return (
    <>
      <h1>Invoice Form</h1>
      <Form>
        <Row className="mb-3">
          <Form.Group as={Col} className="mb-3" controlId="formGridInvoiceNumber">
            <Form.Label>Invoice Number</Form.Label>
            <Form.Control placeholder="Enter Invoice Number" />
          </Form.Group>
          <Form.Group as={Col} className="mb-3" controlId="formGridDateIssue">
            <Form.Label>Date Issue</Form.Label>
            <Form.Control placeholder="Enter Date Issue" />
          </Form.Group>
          <Form.Group as={Col} className="mb-3" controlId="formGridTotalCost">
            <Form.Label>Total Cost</Form.Label>
            <Form.Control placeholder="Enter Total Cost" />
          </Form.Group>
          <Form.Group as={Col} className="mb-3" controlId="formGridAccountNumber">
            <Form.Label>Account Number</Form.Label>
            <Form.Control placeholder="Enter Account Number" />
          </Form.Group>
        </Row>
        {invoiceDetails}
        <Button variant="primary" type="button" onClick={handleAddInvoiceDetail}>
          Add Invoice Detail
        </Button>
        <Button variant="danger" type="button" onClick={handleRemoveInvoiceDetail}>
          Remove Invoice Detail
        </Button>
        <Button variant="primary" type="submit" onClick={handleSubmit}>
          Submit
        </Button>
      </Form>
    </>
  );
}

export default Invoice;