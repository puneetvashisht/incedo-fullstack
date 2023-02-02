import React from 'react';

import Login from './components/Login/Login';
import Home from './components/Home/Home';
import MainHeader from './components/MainHeader/MainHeader';
import {connect} from 'react-redux'

const App=(props)=> {
  // const [isLoggedIn, setIsLoggedIn] = useState(false);

  // const loginHandler = (email, password) => {
  //   // We should of course check email and password
  //   // But it's just a dummy/ demo anyways
  //   setIsLoggedIn(true);
  // };

  // const logoutHandler = () => {
  //   setIsLoggedIn(false);
  // };

  return (
    <React.Fragment>
      <MainHeader />
      <main>
        {!props.isLoggedIn && <Login  />}
        {props.isLoggedIn && <Home />}
      </main>
    </React.Fragment>
  );
}

// todo: use connect to getState and remove local state 

const mapStateToProps = (state)=>{
  console.log(state);
  return {
    isLoggedIn: state.isLoggedIn
  }
}

export default connect(mapStateToProps)(App);
