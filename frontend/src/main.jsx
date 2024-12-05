import React, { Children } from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import {createBrowserRouter,RouterProvider} from 'react-router-dom'
import RootLayout from './Components/Layouts/Rootlayout.jsx'
import CustomerBody from './Components/CustomerBody.jsx'
import RoleSelect from './Components/RoleSelect.jsx'
import CustomerLogin from './Components/customerLogin.jsx'
import VendorLogin from './Components/vendorLogin.jsx'
import VendorBody from './Components/VendorBody.jsx'



const router = createBrowserRouter(
  [{
    element:<RootLayout/>,
    children:[

        { path:"/",
          element:<RoleSelect/>
        },  
        { path:"/login/customer",
          element:<CustomerLogin/>
        },
        { path:"/login/vendor",
          element:<VendorLogin/>
        },
        { path:"/customer",
          element:<CustomerBody/>
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
