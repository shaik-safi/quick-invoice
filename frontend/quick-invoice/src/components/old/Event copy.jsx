import React, { useState, useEffect } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

function Event({ onClose }) {
  const [formData, setFormData] = useState({
    name: '',
    date: null,
    clientName: '',
    clientId: '',
  });

  const [clientNames, setClientNames] = useState([]);

  useEffect(() => {
    fetchClientNames();
  }, []);

  const fetchClientNames = async () => {
    try {
      const response = await fetch('http://localhost:8090/client/get-client-names');
      if (response.ok) {
        const data = await response.json();
        setClientNames(data);
      } else {
        console.error('Error fetching client names.');
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  const handleDateChange = (date) => {
    setFormData({
      ...formData,
      date: date,
    });
  };

  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value,
    });
  };

  const getClientId = async () => {
    try {
      console.log('Fetching client ID for', formData.clientName);
      const clientIdResponse = await fetch(`http://localhost:8090/client/find-by-name?name=${formData.clientName}`);
      if (clientIdResponse.ok) {
        const clients = await clientIdResponse.json();
        console.log('Response from /client/find-by-name:', clients);
        if (clients.length > 0) {
          const firstClient = clients[0];
          const id = firstClient.id;
          console.log('Retrieved Client ID:', id);
          
          setFormData((prevFormData) => ({
            ...prevFormData,
            clientId: id,
          }));
          console.log(formData);
  
          return true;
        }
      }
      console.error('Error fetching client id.');
      return false;
    } catch (error) {
      console.error('Error:', error);
      return false;
    }
  };
  
  
  const handleSubmit = async (event) => {
    event.preventDefault();
    const clientIdAvailable = await getClientId();
  
    if (clientIdAvailable) {
      const formDataWithClientId = {
        name: formData.name,
        date: formData.date,
        clientId: formData.clientId,
      };
  
      const url = 'http://localhost:8090/event/add';
      const requestOptions = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formDataWithClientId),
      };
  
      try {
        const response = await fetch(url, requestOptions);
        if (response.ok) {
          console.log(formDataWithClientId);
          console.log('Event added successfully.');
          onClose();
        } else {
          console.error('Error adding event.');
        }
      } catch (error) {
        console.error('Error:', error);
      }
    }
  };
  

  return (
    <div>
      <h1>Event Form</h1>
      <Form>
        <Form.Group className="mb-3" controlId="formGridClientName">
          <Form.Label>Client Name</Form.Label>
          <Form.Control
            as="select"
            name="clientName"
            value={formData.clientName}
            onChange={handleChange}
          >
            <option value="">Select client name</option>
            {clientNames.map((name) => (
              <option key={name} value={name}>
                {name}
              </option>
            ))}
          </Form.Control>
        </Form.Group>

        <Form.Group className="mb-3" controlId="formGridEventName">
          <Form.Label>Event Name</Form.Label>
          <Form.Control name="name" placeholder="Enter event name" onChange={handleChange} />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formGridEventName">
          <Form.Label>Date</Form.Label>
          <Form.Control name="date" placeholder="Enter event date" onChange={handleChange} />
        </Form.Group>
        {/* <Form.Group as={Col} controlId="formGridDate">
          <Form.Label>Date</Form.Label>
          <DatePicker
            selected={formData.date}
            onChange={handleDateChange}
            placeholderText="Select date"
            dateFormat="dd/MM/yyyy"
          />
        </Form.Group> */}

        <Button variant="primary" type="submit" onClick={handleSubmit}>
          Submit
        </Button>
      </Form>
    </div>
  );
}

export default Event;
