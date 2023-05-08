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
import ViewWorkouts from './components/ViewWorkouts';
import AddWorkout from './components/AddWorkout';
import WorkoutDetail from './components/WorkoutDetail';
import workoutReducer from './store/workout-reducer'
import workoutActiverReducer from './store/workout-active-reducer'
import { applyMiddleware, combineReducers, createStore } from 'redux';
import { Provider } from 'react-redux';
import thunk from 'redux-thunk'
import { composeWithDevTools } from 'redux-devtools-extension'
import ViewActiveWorkouts from './components/ViewActiveWorkouts';

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "/",
        element:<ViewWorkouts/>,
      },
      {
        path: "add",
        element: <AddWorkout/>,
      },
      {
        path: "edit/:id",
        element: <WorkoutDetail/>,
      },
      {
        path: "/view",
        element:<ViewActiveWorkouts/>,
      }
      
    ]
  }
  ]);


  const logger = store => next => action => {
    console.log('dispatching', action)
    let result = next(action)
    console.log('next state', store.getState())
    return result
  }
  
  // create store (all the state)
  const store = createStore(combineReducers({workoutReducer,  workoutActiverReducer}), composeWithDevTools(applyMiddleware(logger,thunk)))
  

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <Provider store={store}>
    <RouterProvider router={router} />
  </Provider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
