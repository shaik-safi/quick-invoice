import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';

function Company() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    companyName: '',
    email: '',
    phone: '',
    city: '',
    state: '',
    zipCode: '',
    country: '',
  });

  const [errors, setErrors] = useState({});

  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value,
    });
  };

  const validateForm = () => {
    const newErrors = {};

    if (!formData.companyName.trim()) {
      newErrors.companyName = 'Company Name is required';
    }
    if (!formData.email.trim()) {
      newErrors.email = 'Email is required';
    }
    if (!formData.phone.trim()) {
      newErrors.phone = 'Phone is required';
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(formData.email)) {
      newErrors.email = 'Invalid email format';
    }
    if (!formData.city.trim()) {
      newErrors.city = 'City is required';
    }
    if (!formData.state.trim()) {
      newErrors.state = 'State is required';
    }
    if (!formData.zip.trim()) {
      newErrors.zip = 'Zip is required';
    }
    if (!formData.country.trim()) {
      newErrors.country = 'Country is required';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = async (event) => {
    event.preventDefault();


      console.log(JSON.stringify(formData));
      const url = 'http://localhost:8080/add-company';
      const response = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        navigate('/');
      } else {
        console.log('error');
      }
  };

  return (
    <>
      <h1>Company Form</h1>
      <Form>
        <Row className="mb-3">
          <Form.Group as={Col} controlId="formGridName">
            <Form.Label>Company Name</Form.Label>
            <Form.Control
              name="companyName"
              placeholder="Enter company name"
              onChange={handleChange}
              isInvalid={!!errors.companyName}
            />
            <Form.Control.Feedback type="invalid">
              {errors.companyName}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group as={Col} controlId="formGridEmail">
            <Form.Label>Email</Form.Label>
            <Form.Control
              type="email"
              name="email"
              placeholder="Enter email"
              onChange={handleChange}
              isInvalid={!!errors.email}
            />
            <Form.Control.Feedback type="invalid">
              {errors.email}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group as={Col} controlId="formGridPassword">
            <Form.Label>Phone</Form.Label>
            <Form.Control
              name="phone"
              placeholder="9**********"
              onChange={handleChange}
              isInvalid={!!errors.phone}
            />
            <Form.Control.Feedback type="invalid">
              {errors.phone}
            </Form.Control.Feedback>
          </Form.Group>
        </Row>

        <Row className="mb-3">
          <Form.Group as={Col} controlId="formGridCity">
            <Form.Label>City</Form.Label>
            <Form.Control name="city" onChange={handleChange} isInvalid={!!errors.city} />
            <Form.Control.Feedback type="invalid">
              {errors.city}
            </Form.Control.Feedback>
          </Form.Group>
          <Form.Group as={Col} controlId="formGridState">
            <Form.Label>State</Form.Label>
            <Form.Control name="state" onChange={handleChange} isInvalid={!!errors.state} />
            <Form.Control.Feedback type="invalid">
              {errors.state}
            </Form.Control.Feedback>
          </Form.Group>
        </Row>

        <Row>
          <Form.Group as={Col} controlId="formGridZip">
            <Form.Label>Zip</Form.Label>
            <Form.Control name="zipCode" onChange={handleChange} isInvalid={!!errors.zip}/>
            <Form.Control.Feedback type="invalid">
              {errors.zip}
            </Form.Control.Feedback>
          </Form.Group>

          <Form.Group as={Col} controlId="formGridCountry">
            <Form.Label>Country</Form.Label>
            <Form.Control name="country" onChange={handleChange} isInvalid={!!errors.country}/>
            <Form.Control.Feedback type="invalid">
              {errors.country}
            </Form.Control.Feedback>
          </Form.Group>
        </Row>

        <Button variant="primary" type="submit" onClick={handleSubmit}>
          Submit
        </Button>
      </Form>
    </>
  );
}

export default Company;
