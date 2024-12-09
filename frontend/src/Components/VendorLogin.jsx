import React from 'react'
import { Link, useNavigate } from 'react-router'
import { checkCustomerDetails } from '../Services/checkCustomerDetails';
import { useState } from 'react';
import { useContext } from "react";
import { DataContext } from "./Layouts/DataContext";
import { checkVendorDetails } from '../Services/checkVendorDetails';

function VendorLogin() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [vendorDetails, setVendorDetails] = useState({});
  const [errorMessage, setErrorMessage] = useState('');
  const { setSharedData } = useContext(DataContext);
  const navigate = useNavigate();


  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const data = await checkVendorDetails(username);
      setVendorDetails(data);
      setErrorMessage('');

      if (password === data.password) {
        setSharedData(data);
        navigate('/vendor'); // Redirect to ticket page
      } else {
        setErrorMessage('Incorrect password. Please try again.');
      }
    } catch (error) {
      setVendorDetails(null);
      setErrorMessage('Please enter a valid username');
    }
  };
  return (
    <div className="flex items-center justify-center h-screen">
      <div className="border-2 border-black p-6 rounded-lg flex flex-col items-center gap-4 w-80 -translate-y-16">

      <h2 className="text-2xl font-bold mb-4">Vendor Login</h2>
        <form onSubmit={handleSubmit}className='w-full flex flex-col gap-4'>
          <input className='w-full border-2 border-black px-4 py-2 rounded' type="text"
            value={username} onChange={(e) => setUsername(e.target.value)} placeholder="Enter username" />

          <input
            className="w-full border-2 border-black px-4 py-2 rounded"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Enter password"
          />

          <button type='submit' className="w-full border-2 border-black px-4 py-2 text-lg rounded-lg font-medium
             hover:bg-black hover:text-white transition">
            Log In
          </button>
        </form>
        {errorMessage && <p className="text-red-500 text-sm">{errorMessage}</p>}

      </div>
    </div>
  )
}

export default VendorLogin
