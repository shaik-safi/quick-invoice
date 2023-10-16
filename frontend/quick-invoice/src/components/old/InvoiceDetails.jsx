import React, { useState } from 'react';
import Form from 'react-bootstrap/Form';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';

function InvoiceDetails(props) {
  const [productName, setProductName] = useState('');
  const [productDescription, setProductDescription] = useState('');
  const [unitPrice, setUnitPrice] = useState('');
  const [quantity, setQuantity] = useState('');

  const handleInputChange = () => {
    const data = {
      productName,
      productDescription,
      unitPrice,
      quantity,
    };
    props.updateInvoiceDetails(props.index, data);
  };

  return (
    <>
      <h1>Add Product {props.index}</h1>
      <Form.Group as={Col} className="mb-3" controlId="formGridProductName">
        <Form.Label>Product Name</Form.Label>
        <Form.Control
          placeholder="Enter Product Name"
          value={productName}
          onChange={(e) => setProductName(e.target.value)}
          onBlur={handleInputChange}
        />
      </Form.Group>
      <Form.Group as={Col} className="mb-3" controlId="formGridProductDescription">
        <Form.Label>Product Description</Form.Label>
        <Form.Control
          placeholder="Enter Product Description"
          value={productDescription}
          onChange={(e) => setProductDescription(e.target.value)}
          onBlur={handleInputChange}
        />
      </Form.Group>
      <Row className="mb-3">
        <Form.Group as={Col} className="mb-3" controlId="formGridUnitPrice">
          <Form.Label>Unit Price</Form.Label>
          <Form.Control
            placeholder="Enter Unit Price"
            value={unitPrice}
            onChange={(e) => setUnitPrice(e.target.value)}
            onBlur={handleInputChange}
          />
        </Form.Group>
        <Form.Group as={Col} className="mb-3" controlId="formGridQuantity">
          <Form.Label>Quantity</Form.Label>
          <Form.Control
            placeholder="Enter Quantity"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
            onBlur={handleInputChange}
          />
        </Form.Group>
      </Row>
    </>
  );
}

export default InvoiceDetails;
