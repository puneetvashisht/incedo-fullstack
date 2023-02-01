import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';

export default function UpdateEmployee() {

    let { id } = useParams();
    console.log(id);

    useEffect(()=>{
        fetch('http://localhost:8080/employees/'+ id)
        .then(res=>res.json())
        .then(data=> {
            setName(data.name);
            setSalary(data.salary);
        })
    }, [])

    const [name, setName] = useState('')
    const [salary, setSalary] = useState('')
    const [message, setMessage] = useState()

    const handleNameChange = (e) =>{
        console.log(e.target.value)
        setName(e.target.value)
    }

    const updateEmployee = () => {
        console.log('update employee..' , salary)
        // id
        fetch('http://localhost:8080/employees/' +id, {
            method: 'PATCH',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify({ salary})

        })
        .then(res=>{
            if(res.status == 201){
                setMessage('Employee updated successfully!')
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
                <input disabled type="text" onChange={handleNameChange} value={name} className="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" />
            </div>
            <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">Salary</span>
                <input type="number"  onChange={(e)=> setSalary(e.target.value)} value={salary} className="form-control" placeholder="Enter salary" aria-label="Username" aria-describedby="basic-addon1" />
            </div>
            <button onClick={updateEmployee} className='btn btn-primary'>Update Employee</button>
        </>

    )
}
