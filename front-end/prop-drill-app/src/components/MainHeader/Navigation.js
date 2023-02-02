import React from 'react';
import {connect} from 'react-redux'

import classes from './Navigation.module.css';

const Navigation = (props) => {
  return (
    <nav className={classes.nav}>
      <ul>
        {props.isLoggedIn && (
          <li>
            <a href="/">Users</a>
          </li>
        )}
        {props.isLoggedIn && (
          <li>
            <a href="/">Admin</a>
          </li>
        )}
        {props.isLoggedIn && (
          <li>
            <button onClick={()=>props.onLogout()}>Logout</button>
          </li>
        )}
      </ul>
    </nav>
  );
};

// connect with dispatch & state
// export default Navigation;
const mapStateToProps = (state)=>{
  console.log(state);
  return {
    isLoggedIn: state.isLoggedIn
  }
}

const mapDispatchToProps = (dispatch) => {
  return {
    onLogout: () => dispatch({type: 'LOGOUT'})
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(Navigation);
