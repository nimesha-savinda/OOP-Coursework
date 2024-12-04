import { Outlet } from "react-router-dom"

import React, { useState } from 'react';
import { DataContext } from "./DataContext";

import Navigation from "../Navigation";

function RootLayout() {

    const [sharedData, setSharedData] = useState({});
    
    
  
    return(
        <DataContext.Provider value={{ sharedData, setSharedData }}>
        <main>           
            <Navigation/>
            <Outlet/>                        
        </main>
        </DataContext.Provider>
        
    )
}
export default RootLayout