import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Client() {
  const navigate = useNavigate();
  const[formData, setFormData] = useState({
    clientName:'',
    email: '',
    phone: '',
    city: '',
    state: '',
    zipCode: '',
    country: '',
  })

  const handleChange = (event) =>{
    setFormData({
      ...formData,[event.target.name]: event.target.value
    })
  }

  const handleSubmit = async (event) =>{
    event.preventDefault()
    console.log(JSON.stringify(formData));
    const url = 'http://localhost:8080/client/add';
    const response = await fetch(url,{
      method: 'POST',
      headers:{
        'Content-Type': 'application/json',
      },
      
      body: JSON.stringify(formData)
    })
    if (response.ok) {
      navigate('/');
    } else {
      console.log("error");
    }
  }
  return (
    <>
    <h1>Client Form</h1>
    <Form>
      <Row className="mb-3">
      <Form.Group className="mb-3" controlId="formGridClientName">
        <Form.Label>Client Name</Form.Label>
        <Form.Control name = "clientName" placeholder="Enter client name" onChange={handleChange} />
      </Form.Group>

      <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>Email</Form.Label>
            <Form.Control
              type="email"
              name="email"
              placeholder="Enter email"
              onChange={handleChange}
            />
          </Form.Group>

          <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Phone</Form.Label>
            <Form.Control
              name="phone"
              placeholder="9**********"
              onChange={handleChange}
            />
          </Form.Group>
        </Row>

        <Row className="mb-3">
          <Form.Group as={Col} controlId="formGridCity">
            <Form.Label>City</Form.Label>
            <Form.Control name="city" onChange={handleChange} />
          </Form.Group>

          <Form.Group as={Col} controlId="formGridState">
            <Form.Label>State</Form.Label>
            <Form.Control name="state" onChange={handleChange} />
          </Form.Group>
        </Row>

        <Row>
          <Form.Group as={Col} controlId="formGridZip">
            <Form.Label>Zip</Form.Label>
            <Form.Control name="zipCode" onChange={handleChange} />
          </Form.Group>

          <Form.Group as={Col} controlId="formGridCountry">
            <Form.Label>Country</Form.Label>
            <Form.Control name="country" onChange={handleChange} />
          </Form.Group>
        </Row>

        <Button variant="primary" type="submit" onClick={handleSubmit}>
          Submit
        </Button>
    </Form>
    </>
  );
}

export default Client;