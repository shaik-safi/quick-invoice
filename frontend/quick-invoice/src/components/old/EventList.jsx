import React, { useState, useEffect } from 'react';
import { Container, Table, Modal } from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Event from './Event';
import './Scroll.css';

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
        console.log('API Called');
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
        <h1 className='mt-3'>Events</h1>
        <Button variant="success" onClick={handleShowClientModal}>
          Add Event
        </Button>
      </div>
      <Table bordered className='mt-3 scrollable-table'>
        <thead className='table-primary'>
          <tr>
            <th>sl.no</th>
            <th>Event Name</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {data &&
            data.map((eventData) => (
              <tr key={eventData.id}>
                <td>{eventData.id}</td>
                <td>{eventData.name}</td>
                <td>{eventData.date}</td>
              </tr>
            ))}
        </tbody>
      </Table>

      <Modal show={showClientModal} onHide={handleCloseClientModal}>
        <Modal.Header closeButton>
          <Modal.Title>Add Event</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Event onClose={handleCloseClientModal} updateClientList={updateClientList} />
        </Modal.Body>
      </Modal>
    </Container>
  );
}

export default EventList;
