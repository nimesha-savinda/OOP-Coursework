import React, { Children } from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import {createBrowserRouter,RouterProvider} from 'react-router-dom'
import RootLayout from './Components/Layouts/Rootlayout.jsx'
import CustomerBody from './Components/CustomerBody.jsx'
import TextInput from './Components/textinput.jsx'



const router = createBrowserRouter(
  [{
    element:<RootLayout/>,
    children:[
        { path:"/",
          element:<CustomerBody/>
        },
        { path:"/home",
          element:<TextInput/>
        },        
    ]
  }]
)

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>   
      <RouterProvider router={router}/>  
  </React.StrictMode>,
)
