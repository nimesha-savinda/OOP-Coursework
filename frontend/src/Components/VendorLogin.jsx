import React from 'react'
import { Link,useNavigate } from 'react-router'
import { checkCustomerDetails } from '../Services/checkCustomerDetails';
import { useState } from 'react';
import { useContext } from "react";
import { DataContext } from "./Layouts/DataContext";

function VendorLogin() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [customerDetails, setCustomerDetails] = useState({});
  const [errorMessage, setErrorMessage] = useState('');
  const { setSharedData } = useContext(DataContext);
  const navigate = useNavigate();

 
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const data = await checkCustomerDetails(username);
      setCustomerDetails(data);
      setErrorMessage('');

      if (password === data.password) {
        setSharedData(data);
        navigate('/customer'); // Redirect to homepage
      } else {
        setErrorMessage('Incorrect password. Please try again.');
      }
    } catch (error) {
      setCustomerDetails(null);
      setErrorMessage('Failed to fetch customer details. Please try again.');
    }
  };
  return (
    <div className="flex items-center justify-center h-screen">
        <div className="border-2 border-black p-6 rounded-lg flex flex-col items-center gap-4 w-80 -translate-y-16">
        
        
{/* 
        <Link  className="w-full " to="/vendor"> */}
          <form onSubmit={handleSubmit}>
          <input className='w-full border-2 border-black px-4 py-2' type="text" 
          value={username} onChange={(e) => setUsername(e.target.value)} placeholder="Enter username" />

          <input
                      className="w-full border-2 border-black px-4 py-2"
                      type="password"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                      placeholder="Enter password"
                    />



          <button  type='submit' className="w-full border-2 border-black px-4 py-2 text-lg rounded-lg font-medium
             hover:bg-black hover:text-white transition">
                Log In
          </button>
          </form>
          {errorMessage && <p className="text-red-500 text-sm">{errorMessage}</p>}

          
          
            
        {/* /</Link> */}
                        
       

        </div>
        
      
    </div>
  )
}

export default VendorLogin
