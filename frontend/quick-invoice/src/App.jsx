import { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from './components/old/Navbar'
import Home from './components/old/Home'
import Company from './components/old/Company'
import GeneratePdf from './components/old/GeneratePdf'
import Client from './components/old/Client'
import Invoice from './components/old/Invoice'
import ClientList from './components/old/ClientList'
import EventList from './components/old/EventList'
import Test from './components/old/Test'
import Container from 'react-bootstrap/esm/Container'
import { BrowserRouter, Routes, Route } from "react-router-dom";


function App() {
  return (
    <><BrowserRouter>
      <Navbar/>
      <Container>
      <Routes>
        <Route path="/" element={<Home />}/>
        <Route path="/client" element={<ClientList />}/>
        <Route path="/event" element={<EventList />}/>
        
        {/* <Route path="/add-client" element={<Client />}/> */}
        {/* <Route path="/company" element={<Company />}/>
        <Route path="/add-client" element={<Client />} />
        <Route path="/list-client" element={<ClientList/>} />
        <Route path="/add-invoice" element={<Invoice />} />
        <Route path="/generate-pdf" element={<GeneratePdf />} />
        <Route path="/test" element={<Test/>} /> */}
          {/* <Route path="*" element={<NoPage />} /> */}
      </Routes>
      </Container>
    </BrowserRouter>
    </>
  );
}

export default App;