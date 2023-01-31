import logo from './logo.svg';
import './App.css';
import Message from './Message';
import Badge from './Badge';
import Clock from './Clock';
import Card from './Card';
import BadgeWithClass from './BadgeWithClass';
import ViewEmployees from './ViewEmployees';
import AddEmployee from './AddEmployee';
import Dropdown from './Dropdown';

function App() {

  const courses = [
    {id:34, title: 'React', summary: 'lib from facebook...'},
    {id:3, title: 'Angular', summary: 'framework from google...'},
    {id:4, title: 'Ember', summary: 'open source ui framework...'},
  ]

  let listCourses = courses.map((course, i)=>{
    return <Card key={course.id} title={course.title}></Card>
  })

  return (

    <>
    <Dropdown></Dropdown>
    {/* <AddEmployee></AddEmployee>
    <hr/>
     <ViewEmployees></ViewEmployees> */}
    </>
   
    
    // <BadgeWithClass caption="Votes"></BadgeWithClass>
    // <div className="container">
    //   <div className="row">
    //   {listCourses}
    //   </div>
     /* <h2>Welcome to React!</h2>
     <Message></Message>
     <Badge></Badge>
     <Clock today={new Date()}></Clock> */
    
    // </div>
  );
}

export default App;
