import logo from './logo.svg';
import './App.css';
import ViewEmployees from './components/ViewEmployees';
import ListEmployees from './components/ListEmployees';
import AddEmployee from './components/AddEmployee';

function App() {
  return (
    <div className="container">
      <AddEmployee></AddEmployee>
      <hr/>
      <ViewEmployees/> 
      <hr></hr>
      <ListEmployees></ListEmployees>
    </div>
  );
}

export default App;
