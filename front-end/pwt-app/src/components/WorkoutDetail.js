import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import Autohide from './Autohide';
import { Button } from 'react-bootstrap';

export default function WorkoutDetail() {
    const params = useParams();
    const [title, setTitle] = useState('')
    const [cbpm, setCbpm] = useState()
    const [showStatus, setShowStatus]= useState(false);

    useEffect(() => {
        console.log(params.id)

        fetch('http://localhost:8080/workouts/' + params.id)
        .then(res => res.json())
        .then(data => {
            console.log(data);
            setTitle(data.title)
            setCbpm(data.cbpm)
        });
    }, [])

    const updateWorkout = () => {
        console.log({title, cbpm})
        fetch('http://localhost:8080/workouts/', {
            method: 'PATCH',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify({id: params.id, cbpm})
        })
        .then(res=> setShowStatus(true))


    }


    return (
        <>
        {showStatus && <Autohide message="Workout is updated!"></Autohide>}
            <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">Title</span>
                <input type="text" disabled value={title} className="form-control" placeholder="Enter Title" aria-label="Username" aria-describedby="basic-addon1" />
            </div>
            <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">Calories Burnt(per minute)</span>
                <input type="number" onChange={(e)=> setCbpm(e.target.value)} value={cbpm} className="form-control" placeholder="Enter CBPM" aria-label="Username" aria-describedby="basic-addon1" />
            </div>
            <div className="input-group mb-3">
                <Button onClick={updateWorkout} variant="primary">Update Workout</Button>
            </div>
        </>
    )
}
