import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import 'bootstrap/dist/css/bootstrap.css'
import App from './App';
import reportWebVitals from './reportWebVitals';

import {
  createBrowserRouter,
  RouterProvider,
  Route,
  Link,
} from "react-router-dom";
import ViewEmployees from './components/ViewEmployees';
import AddEmployee from './components/AddEmployee';
import UpdateEmployee from './components/UpdateEmployee';

const router = createBrowserRouter([
{
  path: "/",
  element: <App />,
  children: [
    {
      path: "view",
      element: <ViewEmployees />,
    },
    {
      path: "add",
      element: <AddEmployee />,
    },
    {
      path: "update/:id",
      element: <UpdateEmployee />,
    }
  ]
}
]);
  
  // {
  //   path: "/",
  //   element: <Home/>,
  // },
  // {
  //   path: "about",
  //   element:<About/>,
  // },
// ]);


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <RouterProvider router={router} />
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
