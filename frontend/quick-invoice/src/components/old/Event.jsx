import React, { useState, useEffect } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

function Event({ onClose }) {
  const [clientNames, setClientNames] = useState([]);
  const [formData, setFormData] = useState({
    clientId: '',
    name: '',
    date: '',
  });

  useEffect(() => {
    fetch('http://localhost:8090/client/find-all')
      .then(response => response.json())
      .then(data => setClientNames(data));
  }, []);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

const handleSubmit = (event) => {
  event.preventDefault();

  const selectedClient = clientNames.find(client => client.id === Number(formData.clientId));

  console.log('formData.clientId:', formData.clientId);
console.log('clientNames:', clientNames);
console.log('selectedClient:', selectedClient);

  if (selectedClient) {
    const newEvent = {
      name: formData.name,
      date: formData.date,
      client: {
        id: selectedClient.id,
        name: selectedClient.name,
        phone: selectedClient.phone,
        email: selectedClient.email,
        city: selectedClient.city,
        state: selectedClient.state,
        zipCode: selectedClient.zipCode,
        country: selectedClient.country,
      },
    };
    console.log('Data to be sent:', newEvent);

    fetch('http://localhost:8090/event/add', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newEvent),
    })
    .then(response => response.json())
    .then(data => {
      console.log('Event added successfully:', data);
      onClose();
    })
    .catch(error => {
      console.error('Error adding event:', error);
    });
  } else {
    console.error('Selected client not found.');
  }
};

  return (
    <div>
      <h1>Event Form</h1>
      <Form>
        <Form.Group className="mb-3" controlId="formGridClientId">
          <Form.Label>Client Name</Form.Label>
          <Form.Control
            as="select"
            name="clientId"
            value={formData.clientId}
            onChange={handleChange}
          >
            <option value="">Select client</option>
            {clientNames.map(client => (
              <option key={client.id} value={client.id}>
                {client.name}
              </option>
            ))}
          </Form.Control>
        </Form.Group>

        <Form.Group className="mb-3" controlId="formGridEventName">
          <Form.Label>Event Name</Form.Label>
          <Form.Control name="name" placeholder="Enter event name" onChange={handleChange} />
        </Form.Group>

        <Form.Group className="mb-3" controlId="formGridDate">
          <Form.Label>Date</Form.Label>
          <Form.Control name="date" placeholder="Enter event date" onChange={handleChange} />
        </Form.Group>

        <Button variant="primary" type="submit" onClick={handleSubmit}>
          Submit
        </Button>
      </Form>
    </div>
  );
}

export default Event;
