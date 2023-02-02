import React, { useState } from 'react'
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router-dom';

export default function Login() {
  
    const [name, setName] = useState('')
    const [password, setPassword] = useState('')
    const [message, setMessage] = useState()

    const navigate = useNavigate();

    const handleNameChange = (e) =>{
        console.log(e.target.value)
        setName(e.target.value)
    }

    const login = () => {
        fetch('http://localhost:8080/auth')
        .then(res=> res.json())
        .then(res=>{
            if(res.auth){
                // setMessage('Employee added successfully!')
                console.log("Logged in successfully!");
                navigate('/landing');
            }
            else{
                console.log("Logged in failed!");
                setMessage('Invalid login!')
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
        {message && (<div class="alert alert-danger" role="alert">
        {message}
        </div>)}
            <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">Email</span>
                <input type="email" onChange={handleNameChange} value={name} className="form-control" placeholder="Enter email" aria-label="Enter email" aria-describedby="basic-addon1" />
            </div>
            <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">Password</span>
                <input type="password"  onChange={(e)=> setPassword(e.target.value)} value={password} className="form-control" placeholder="Enter password" aria-label="Username" aria-describedby="basic-addon1" />
            </div>
            <Button onClick={login} variant="primary">Login</Button>
        </>

    )
  
}
