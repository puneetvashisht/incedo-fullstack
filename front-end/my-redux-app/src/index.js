import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import 'bootstrap/dist/css/bootstrap.css'
import App from './App';
import reportWebVitals from './reportWebVitals';
import { createStore } from 'redux';
import { Provider } from 'react-redux';


const initialState = {
  employees: [
      {id: 1, name: "Ravi", salary: 34343},
      {id: 2, name: "Priya", salary: 44343},
  ]
}
// create reducers to modify the state --- immutable
const reducer = (state = initialState, action)=> {
  switch (action.type) {
      case 'ADD_EMPLOYEES':
          //  state.employees.push(action.payload)
          let newEmployees = [...state.employees, action.payload]
          return {employees: newEmployees}
      case 'DELETE_EMPLOYEE':
              let remainingEmployees = state.employees.filter((e)=>e.id!=action.payload.id)
              return {employees: remainingEmployees}
      default:
          return {employees: state.employees};
  }
}

// create store (all the state)
const store = createStore(reducer)

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <Provider store={store}>
    <App />
  </Provider>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
