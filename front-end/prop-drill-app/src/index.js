import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {createStore} from 'redux'

const initialState = {
  isLoggedIn: false
}
// create reducers to modify the state --- immutable
const reducer = (state = initialState, action)=> {
  switch (action.type) {
      case 'LOGIN':
          return { isLoggedIn: true}
      case 'LOGOUT':
        return { isLoggedIn: false}
      default:
          return { isLoggedIn: false};
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
