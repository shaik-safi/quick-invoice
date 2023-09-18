import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from './components/Navbar'
import Home from './components/Home'
import Company from './components/Company'
import Client from './components/Client'
import Invoice from './components/Invoice'
import ClientList from './components/ClientList'
import Container from 'react-bootstrap/esm/Container'
import { BrowserRouter, Routes, Route } from "react-router-dom";


function App() {
  return (
    <><BrowserRouter>
      <Navbar/>
      <Container>
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="/company" element={<Company />}/>
        <Route path="/add-client" element={<Client />} />
        <Route path="/list-client" element={<ClientList/>} />
        <Route path="/add-invoice" element={<Invoice />} />
          {/* <Route path="*" element={<NoPage />} /> */}
      </Routes>
      </Container>
    </BrowserRouter>
    </>
  );
}

export default App;