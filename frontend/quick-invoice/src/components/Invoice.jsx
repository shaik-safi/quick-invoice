import React, { useState} from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import InvoiceDetails from './InvoiceDetails';

import { useNavigate } from 'react-router-dom';

function Invoice() {
  
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    invoiceNumber: '',
    dateIssue: '',
    clientName: '',
    accountNumber: '',
  });
  const [invoiceDetails, setInvoiceDetails] = useState([]);

  function handleAddInvoiceDetail() {
    setInvoiceDetails([...invoiceDetails, {}]);
  }

  function handleRemoveInvoiceDetail(index) {
    const newInvoiceDetails = [...invoiceDetails];
    newInvoiceDetails.splice(index, 1);
    setInvoiceDetails(newInvoiceDetails);
  }

  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value,
    });
  };

  const updateInvoiceDetails = (index, data) => {
    const updatedInvoiceDetails = [...invoiceDetails];
    updatedInvoiceDetails[index] = data;
    setInvoiceDetails(updatedInvoiceDetails);
  };

  async function makePostRequest(invoiceDetails,invoiceId) {
    const url = 'http://localhost:8080/add-invoice-details?invoiceId=' + invoiceId;
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(invoiceDetails),
    });
    return response.ok;
  }

  const handleSubmit = async (event) => {
    event.preventDefault();
  
    const clientUrl = 'http://localhost:8080/get-clientid?clientName=' + formData.clientName;
    const clientResponse = await fetch(clientUrl, {
      method: 'GET'
    });
  
    if (clientResponse.ok) {
      const clientId = await clientResponse.json();
      console.log(clientId);
  
      const addInvoiceUrl = 'http://localhost:8080/add-invoice?clientId=' + clientId;
      const addClientResponse = await fetch(addInvoiceUrl, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });
  
      if (addClientResponse.ok) {
        const invoiceUrl = 'http://localhost:8080/get-invoiceid?invoiceNumber=' + formData.invoiceNumber;
        const invoiceResponse = await fetch(invoiceUrl, {
          method: 'GET'
        });
  
        if (invoiceResponse.ok) {
          const invoiceId = await invoiceResponse.json();
          console.log(invoiceId);
  
          // Post invoice details
          for (const invoiceDetail of invoiceDetails) {
            const success = await makePostRequest(invoiceDetail, invoiceId);
            if (success) {
              console.log('POST request successful for invoiceDetail:', invoiceDetail);
            } else {
              console.log('Error in POST request for invoiceDetail:', invoiceDetail);
            }
          }
  
          // Navigate to the desired location
          navigate('/');
        } else {
          console.log("Error getting invoice ID");
        }
        console.log("form");
      } else {
        console.log("Error adding invoice");
      }
    } else {
      console.log("Error getting client ID");
    }
  
    console.log('Form Data:', formData);
    console.log('Invoice Details:', invoiceDetails);
  }
  
  

  return (
    <>
      <h1>Invoice Form</h1>
      <Form onSubmit={handleSubmit}>
        <Row className="mb-3">
          <Form.Group as={Col} className="mb-3" controlId="formGridInvoiceNumber">
            <Form.Label>Invoice Number</Form.Label>
            <Form.Control
              name="invoiceNumber"
              placeholder="Enter Invoice Number"
              onChange={handleChange}
            />
          </Form.Group>
          <Form.Group as={Col} className="mb-3" controlId="formGridDateIssue">
            <Form.Label>Date Issue</Form.Label>
            <Form.Control
              name="dateIssue"
              placeholder="Enter Date Issue"
              onChange={handleChange}
            />
          </Form.Group>
        </Row>
        <Row className="mb-3">
          <Form.Group as={Col} className="mb-3" controlId="formGridClientName">
            <Form.Label>Client Name</Form.Label>
            <Form.Control
              name="clientName"
              placeholder="Enter Client Name"
              onChange={handleChange}
            />
          </Form.Group>
          <Form.Group as={Col} className="mb-3" controlId="formGridAccountNumber">
            <Form.Label>Account Number</Form.Label>
            <Form.Control
              name="accountNumber"
              placeholder="Enter Account Number"
              onChange={handleChange}
            />
          </Form.Group>
        </Row>
        {invoiceDetails.map((invoiceDetail, index) => (
          <InvoiceDetails
            key={index}
            index={index}
            updateInvoiceDetails={updateInvoiceDetails}
          />
        ))}
        <Row>
          <Button as={Col} className="m-4" variant="primary" type="button" onClick={handleAddInvoiceDetail}>
            Add Invoice Detail
          </Button>
          {invoiceDetails.length > 0 && (
            <Button as={Col} className="m-4" variant="danger" type="button" onClick={() => handleRemoveInvoiceDetail(invoiceDetails.length - 1)}>
              Remove Invoice Detail
            </Button>
          )}
          <Button as={Col} className="m-4" variant="primary" type="submit" onClick={handleSubmit}>
            Submit
          </Button>
        </Row>
      </Form>
    </>
  );
}
export default Invoice;
