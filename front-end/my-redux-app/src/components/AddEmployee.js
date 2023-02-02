import React, { useState } from 'react'
import { connect } from 'react-redux'

const AddEmployee  = (props) => {

    const [name, setName] = useState('')
    const [salary, setSalary] = useState('')
    const [message, setMessage] = useState()

    const handleNameChange = (e) =>{
        console.log(e.target.value)
        setName(e.target.value)
    }

    const addEmployee = () => {
        console.log('add employee..' , name, salary)
       // add to exisitng array of employees
       props.onAddEmployees({id: 45, name, salary})
    }

    // let messageAlert = ''
    // if(message){
    //     messageAlert= (<div class="alert alert-success" role="alert">
    //     {message}
    //     </div>)
    // }
    
    return (
        <>
        {message && (<div class="alert alert-success" role="alert">
        {message}
        </div>)}
            <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">Name</span>
                <input type="text" onChange={handleNameChange} value={name} className="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" />
            </div>
            <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">Salary</span>
                <input type="number"  onChange={(e)=> setSalary(e.target.value)} value={salary} className="form-control" placeholder="Enter salary" aria-label="Username" aria-describedby="basic-addon1" />
            </div>
            <button onClick={addEmployee} className='btn btn-primary'>Add Employee</button>
        </>

    )
}

const mapDispatchToProps = (dispatch)=> {
    return {
      onAddEmployees: (employee) => dispatch({type: 'ADD_EMPLOYEES', payload: employee})
    }
  }
  
  export default connect(null, mapDispatchToProps)(AddEmployee)
