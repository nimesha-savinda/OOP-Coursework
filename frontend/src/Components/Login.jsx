import React from 'react'
import { Link } from 'react-router'

function Login() {
  return (
    <div className="flex items-center justify-center h-screen">
        <div className="border-2 border-black p-6 rounded-lg flex flex-col items-center gap-4 w-80 -translate-y-16">
        <input className='w-full border-2 border-black px-4 py-2' type="text" placeholder="Enter username" />

        <Link  className="w-full " to="/vendor">
            <button  className="w-full border-2 border-black px-4 py-2 text-lg rounded-lg font-medium
             hover:bg-black hover:text-white transition">
                Log In
            </button>
        </Link>
                        
       

        </div>
        
      
    </div>
  )
}

export default Login
