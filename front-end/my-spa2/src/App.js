import logo from './logo.svg';
import './App.css';
import Login from './components/Login';
import { Outlet } from 'react-router-dom';

function App() {
  return (
    <div className="container">
      <Outlet/>
    </div>
  );
}

export default App;
