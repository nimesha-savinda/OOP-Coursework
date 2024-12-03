import React, { Children } from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import {createBrowserRouter,RouterProvider} from 'react-router-dom'
import RootLayout from './Components/Layouts/Rootlayout.jsx'
import CustomerBody from './Components/CustomerBody.jsx'
import TextInput from './Components/textinput.jsx'
import RoleSelect from './Components/RoleSelect.jsx'
import Login from './Components/Login.jsx'
import VendorBody from './Components/VendorBody.jsx'



const router = createBrowserRouter(
  [{
    element:<RootLayout/>,
    children:[
        { path:"/customer",
          element:<CustomerBody/>
        },
        { path:"/login",
          element:<Login/>
        },
        { path:"/",
          element:<RoleSelect/>
        },
        { path:"/vendor",
          element:<VendorBody/>
        },        
    ]
  }]
)

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>   
      <RouterProvider router={router}/>  
  </React.StrictMode>,
)
