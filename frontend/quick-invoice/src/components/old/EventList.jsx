import React, { useState, useEffect } from 'react';
import { Container, Table, Modal } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Client from './Client';

function EventList() {
  const [data, setData] = useState(null);
  const [showClientModal, setShowClientModal] = useState(false);

  const handleShowClientModal = () => {
    setShowClientModal(true);
  };

  const handleCloseClientModal = () => {
    setShowClientModal(false);
  };

  const updateClientList = async () => {
    try {
      const clientUrl = "http://localhost:8090/event/find-all";
      const clientsResponse = await fetch(clientUrl, {
        method: 'GET'
      });

      if (clientsResponse.ok) {
        const clientsData = await clientsResponse.json();
        setData(clientsData);
        console.error('API Called');
      } else {
        console.error('API request failed');
      }
    } catch (error) {
      console.error('Error during API request:', error);
    }
  };

  useEffect(() => {
    updateClientList();
  }, []);

  return (
    <Container>
      <div className='d-flex justify-content-between align-items-center'>
        <h1 className='mt-3'>List of Clients</h1>
        <Button variant="success" onClick={handleShowClientModal}>
          Add Client
        </Button>
      </div>
      <Table bordered className='mt-3'>
        <thead className='table-primary'>
          <tr>
            <th>sl.no</th>
            <th>Client Name</th>
            <th>email</th>
            <th>phone</th>
            <th>city</th>
            <th>state</th>
            <th>zipCode</th>
            <th>country</th>
          </tr>
        </thead>
        <tbody>
          {data &&
            data.map((clientData) => (
              <tr key={clientData.id}>
                <td>{clientData.id}</td>
                <td>{clientData.name}</td>
                <td>{clientData.email}</td>
                <td>{clientData.phone}</td>
                <td>{clientData.city}</td>
                <td>{clientData.state}</td>
                <td>{clientData.zipCode}</td>
                <td>{clientData.country}</td>
              </tr>
            ))}
        </tbody>
      </Table>

      <Modal show={showClientModal} onHide={handleCloseClientModal}>
        <Modal.Header closeButton>
          <Modal.Title>Add Client</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Client onClose={handleCloseClientModal} />
        </Modal.Body>
      </Modal>
    </Container>
  );
}

export default EventList;
