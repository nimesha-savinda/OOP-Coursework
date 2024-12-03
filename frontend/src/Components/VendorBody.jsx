import React, { useEffect } from 'react'
import TextInput from './textinput'
import { useState } from 'react'
import { getTicketPool } from '../Services/getTicketPool'
import { removeTickets } from '../Services/removeTickets'


import { getLatestConfiguration } from '../Services/getLatestConfiguration'



function VendorBody() {
    const [id, setId] = useState('674724d7aa0dd56b7f3c7855');
    const [ticketCount, setTicketCount] = useState('');
    const [responseMessage, setResponseMessage] = useState('');
    const[configurationFile,setConfigurationFile] = useState({})
    const[ticket_pool,setTicket_pool]=useState({})

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            if(ticketCount>configurationFile.retrieval_rate ){
                setResponseMessage('Retrieval Limit Exceeded..!');

            }else{
                const response = await removeTickets(id, ticketCount);
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
        //   const intervalId = setInterval(getTicketPool, 5000);
        //    // Clean up the interval on component unmount 
        //     return () => clearInterval(intervalId);
          
       
          },[])
          
    
  return (
    <div className=' py-8 px-16 mt-[2%]'>
        <div className="flex flex-col items-center justify-evenly">
            <div className='flex  items-center justify-between w-1/5'>
                <div className='text-1xl items-center font-semibold'>
                    <p>Available Tickets</p>
                </div>
                <div className='text-3xl items-center font-semibold'>
                    {ticket_pool.availableTickets}
                </div>
            </div>
            <div className='flex bg-white items-center justify-between w-1/5'>
                {/* <div className='text-1xl items-center font-semibold'>
                    <p>Add amount:</p>
                </div> */}
                <div className='text-3xl items-center font-semibold'>
                    
                </div>
            </div>
            <dev className="px-4 py-2">
               <a>Only {configurationFile.release_rate} at a time</a>
               <form onSubmit={handleSubmit}>
               <input
                            type="number"
                            value={ticketCount}
                            onChange={(e) => setTicketCount(e.target.value)}
                            placeholder="Enter Ticket Count"
                        />
                        <button type='submit' className="border-2 border-black px-4 py-1 text-lg rounded-lg mt-2 font-medium hover:bg-black hover:text-white transition">
                  Add Tickets
                </button>
               </form>
                
            </dev> 
            <p>Response: {responseMessage}</p>
        </div>   
    </div>
  )
}

export default VendorBody
