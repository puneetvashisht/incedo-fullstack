import React, { useState } from 'react'

export default function AddEmployee() {

    const [name, setName] = useState('')
    const [salary, setSalary] = useState('')
    const [message, setMessage] = useState()

    const handleNameChange = (e) =>{
        console.log(e.target.value)
        setName(e.target.value)
    }

    const addEmployee = () => {
        console.log('add employee..' , name, salary)
        fetch('http://localhost:8080/employees', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify({name, salary})

        })
        .then(res=>{
            if(res.status == 201){
                setMessage('Employee added successfully!')
            }
        });
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
