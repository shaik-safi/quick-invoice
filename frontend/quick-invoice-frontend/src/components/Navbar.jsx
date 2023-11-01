import React from 'react';
import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <div className="bg-blue-600">
      <div className="sidebar fixed top-0 bottom-0 lg:left-0 p-2 w-[300px] overflow-y-auto text-center bg-gray-900">
        <div className="text-gray-100 text-xl">
          <div className="p-2.5 mt-1 flex items-center">
            <i className="bi bi-app-indicator px-2 py-1 rounded-md bg-blue-600"></i>
            <h1 className="font-bold text-gray-200 text-[15px] ml-3">Quick Invoice</h1>
          </div>
          <div className="my-2 bg-gray-600 h-[1px]"></div>
        </div>
        <div className="p-2.5 mt-3 flex items-center rounded-md px-4 duration-300 cursor-pointer hover:bg-blue-600 text-white">
          <i className="bi bi-app-indicator px-2 py-1 rounded-md bg-red-600"></i>
          <Link to="/" className="text-[15px] ml-4 text-gray-200 font-bold">Home</Link>
        </div>
        <div className="p-2.5 mt-3 flex items-center rounded-md px-4 duration-300 cursor-pointer hover-bg-blue-600 text-white">
          <i className="bi bi-app-indicator px-2 py-1 rounded-md bg-red-600"></i>
          <Link to="/event" className="text-[15px] ml-4 text-gray-200 font-bold">Event</Link>
        </div>
        <div className="p-2.5 mt-3 flex items-center rounded-md px-4 duration-300 cursor-pointer hover-bg-blue-600 text-white">
          <i className="bi bi-app-indicator px-2 py-1 rounded-md bg-red-600"></i>
          <Link to="/client" className="text-[15px] ml-4 text-gray-200 font-bold">Client</Link>
        </div>
      </div>
    </div>
  );
}
