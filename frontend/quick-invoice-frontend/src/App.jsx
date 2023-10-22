import { useState } from 'react';
import Navbar from './components/Navbar'
import Home from './components/Home'
import Event from './components/Event'
import Client from './components/Client'
// import Home from './components/Home'
import { BrowserRouter, Routes, Route } from "react-router-dom";


function App() {
  return (
    <><BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/event" element={<Event/>}/>
        <Route path="/client" element={<Client/>}/>
        {/* <Route path="/" element={<Home/>}/> */}
      </Routes>
    </BrowserRouter>
    </>
  );
}
export default App;