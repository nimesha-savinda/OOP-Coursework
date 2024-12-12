import React, { useEffect } from 'react'
import TextInput from './textinput'
import { useState } from 'react'
import { getTicketPool } from '../Services/getTicketPool'
import { removeTickets } from '../Services/removeTickets'
import { useContext } from "react";
import { DataContext } from "./Layouts/DataContext";


import { getLatestConfiguration } from '../Services/getLatestConfiguration'



function CustomerBody() {
    const [id, setId] = useState('');
    const [ticketCount, setTicketCount] = useState('');
    const [responseMessage, setResponseMessage] = useState('');
    const[configurationFile,setConfigurationFile] = useState({})
    const[ticket_pool,setTicket_pool]=useState({})
    const[availableTickets,setAvailableTickets]=useState()

    const { sharedData, setSharedData } = useContext(DataContext);


    


    const handleSubmit = async (e) => {
        e.preventDefault();
        getTicketPool()
          .then((data)=>setTicket_pool(data))
          
          console.log("new value is"+ticket_pool.availableTickets)

        try {
            if(ticketCount>configurationFile.retrieval_rate ){
                setResponseMessage('Retrieval Limit Exceeded..!');


            }else{
                const response = await removeTickets(sharedData.id, ticketCount);
                setResponseMessage(response);
            }            
               
             // Display the response from the backend
        } catch (e) {
            setResponseMessage('Failed to remove tickets. Please try again.');
            
        }
    };
   

    useEffect(()=>{
        getLatestConfiguration()
            .then((data)=>setConfigurationFile(data))
            console.log(configurationFile)
        getTicketPool()
          .then((data)=>setTicket_pool(data))
          },[])
          
          
    
  return (
    <div className="flex items-center justify-center h-screen">
        <div className="border-2 border-black p-6 rounded-lg flex flex-col items-center gap-6 w-80 -translate-y-16">
            <div className='flex  items-center justify-between w-1/5'>
                <div className='text-1xl items-center font-semibold'>
                    <p>Available Tickets</p>
                </div>
                <div className='text-3xl items-center font-semibold'>
                    {ticket_pool.availableTickets}
                </div>
            </div>
            <div className='flex bg-white items-center justify-between w-1/5'>
                <div className='text-3xl items-center font-semibold'>
                    
                </div>
            </div>
            <dev className="w-full flex flex-col gap-4">
               <a>Only {configurationFile.retrieval_rate} at a time</a>
               <form className='w-full flex flex-col gap-4' onSubmit={handleSubmit}>
               <input
                            type="number"
                            value={ticketCount}
                            onChange={(e) => setTicketCount(e.target.value)}
                            placeholder="Enter Ticket Count"
                        />
                        <button type='submit' className="border-2 border-black px-4 py-1 text-lg rounded-lg mt-2 font-medium hover:bg-black hover:text-white transition">
                  Buy Tickets
                </button>
               </form>
                
            </dev> 
            {responseMessage &&<p className="text-green-500 text-sm">{responseMessage}</p>}
        </div>   
    </div>
  )
}

export default CustomerBody
