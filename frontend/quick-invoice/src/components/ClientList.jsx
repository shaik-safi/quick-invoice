import React, { useState, useEffect } from 'react';
import { Container, Table } from 'react-bootstrap';

function ClientList() {
  const [data, setData] = useState(null);

  const fetchData = async () => {
    try {
      const clientUrl = "http://localhost:8080/client/find-by-id";
      const clientsResponse = await fetch(clientUrl, {
        method: 'GET'
      });

      if (clientsResponse.ok) {
        const clientsData = await clientsResponse.json();
        setData(clientsData);
      } else {
        console.error('API request failed');
      }
    } catch (error) {
      console.error('Error during API request:', error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <><Container>
      <h1 className='mt-3'>List of Clients</h1>
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
              <tr key={clientData.clientId}>
                <td>{clientData.clientId}</td>
                <td>{clientData.clientName}</td>
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
      </Container>
    </>
  );
}

export default ClientList;