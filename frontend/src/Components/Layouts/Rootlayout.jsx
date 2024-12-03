import { Outlet } from "react-router-dom"

import { useState } from "react";

import Navigation from "../Navigation";

function RootLayout(params) {
    
    return(
        
        <main>
            
            <Navigation/>
            <Outlet/>
            
            
        </main>
        
    )
}
export default RootLayout