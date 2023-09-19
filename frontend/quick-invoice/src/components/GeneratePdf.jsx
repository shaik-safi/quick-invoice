import React, { useRef, useState} from 'react';
import { useNavigate } from 'react-router-dom';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';
import { Container, Row, Col, Table, Button, Form } from 'react-bootstrap';

function GeneratePdf() {
  const pdfRef = useRef(null);
  const navigate = useNavigate();
  const [companyNameInput, setCompanyNameInput] = useState('');
  const [clientNameInput, setClientNameInput] = useState('');
  const [data, setData] = useState(null);

  const fetchData = async () => {
    try {
      console.log(companyNameInput);
      console.log(clientNameInput);
      const invoiceUrl = `http://localhost:8080/get-invoice?companyName=${companyNameInput}&clientName=${clientNameInput}`;
      const invoiceResponse = await fetch(invoiceUrl, {
        method: 'GET'
      });

      if (invoiceResponse.ok) {
        const responseData = await invoiceResponse.json();
        setData(responseData);
        console.log(data);
      } else {
        console.error('API request failed');
      }
    } catch (error) {
      console.error('Error during API request:', error);
    }
  };

  const { company, companyClient, invoiceDetails, invoices } = data || {};

  const downloadPDF = () => {
    const input = pdfRef.current;

    html2canvas(input).then((canvas) => {
      const imgData = canvas.toDataURL('image/png');
      const pdf = new jsPDF('p', 'mm', 'a4');
      const imgWidth = 210;
      const imgHeight = (canvas.height * imgWidth) / canvas.width;

      pdf.addImage(imgData, 'PNG', 0, 0, imgWidth, imgHeight);
      pdf.save('downloaded.pdf');
      navigate('/');
    });
  };

  return (
    <div>
      <Form>
        <Form.Group controlId="clientName">
          <Form.Label>Enter details</Form.Label>
          <Row>
          <Col>
          <Form.Control
            type="text"
            placeholder="Enter company name"
            value={companyNameInput}
            onChange={(e) => setCompanyNameInput(e.target.value)}
          />
          </Col>
          <Col>
          <Form.Control
            type="text"
            placeholder="Enter client name"
            value={clientNameInput}
            onChange={(e) => setClientNameInput(e.target.value)}
          />
          </Col>
          </Row>
        </Form.Group>
        <Button variant="primary" className='mt-3' onClick={fetchData}>
          Fetch Data
        </Button>
      </Form>

      {data ? (
        <>
        <Container className='p-5' ref={pdfRef}>
          <h1 className='text-center mb-3'>Invoice</h1>
          <h2 className='text-center mb-5'>{company.companyName}</h2>
          <Row className='mb-5'>
            <Col>
              <h3 className='mb-3'>Client Information:</h3>
              <p>Name: {companyClient.clientName}</p>
              <p>Phone: {companyClient.phone}</p>
              <p>Email: {companyClient.email}</p>
              <p>Address: {companyClient.city}, {companyClient.state}, {companyClient.zipCode}, {companyClient.country}</p>
            </Col>
            <Col className='col-3'>
              <p>Invoice Number: {invoices.invoiceNumber}</p>
              <p>Invoice Date: {invoices.dateIssue}</p>
            </Col>
          </Row>
          <Table bordered className='mb-5'>
            <thead className='table-primary'>
              <tr>
                <th>Product Name</th>
                <th>Product Description</th>
                <th>Unit Price</th>
                <th>Quantity</th>
                <th>Amount</th>
              </tr>
            </thead>
            <tbody>
              {invoiceDetails.map((item) => (
                <tr key={item.productId}>
                  <td>{item.productName}</td>
                  <td>{item.productDescription}</td>
                  <td>{item.unitPrice}</td>
                  <td>{item.quantity}</td>
                  <td>{item.unitPrice * item.quantity}</td>
                </tr>
              ))}
            </tbody>
          </Table>
          <Row>
            <Col>
              <h3>Company Information:</h3>
              <p>Name: {company.companyName}</p>
              <p>Phone: {company.phone}</p>
              <p>Email: {company.email}</p>
              <p>Address: {company.city}, {company.state}, {company.zipCode}, {company.country}</p>
            </Col>
            <Col className='col-3 p-4'>
            <h4>Total Amount: ₹{invoices.totalCost}</h4>
            </Col>
          </Row>
          <h4  className='mt-5 text-center'>Thank you for your business!</h4>
        </Container>
        <Button variant="primary" onClick={downloadPDF} >
        Download PDF
      </Button>
      </>
      ) : (
        <p>No data fetched yet.</p>
      )}
    </div>
  );
}

export default GeneratePdf;