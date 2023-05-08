import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import Autohide from './Autohide';
import { Button } from 'react-bootstrap';

import * as actions from '../store/workout-active-actions'
import { connect } from 'react-redux';

const WorkoutDetail = (props) => {
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
    const startWorkout = () => {

        const worktoutActive = {
            "gymUser": {
                "email": "test3@test.com"
            },
            "workout": {
                "id": params.id
            }
        
        } 
       props.onStartWorkout(worktoutActive)
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
            <div className="input-group mb-3">
                <Button onClick={startWorkout} variant="primary">Start Workout</Button>
            </div>
            {/* <div className="input-group mb-3">
                <Button onClick={()=>props.onEndWorkout(params.id)} variant="primary">End Workout</Button>
            </div> */}
        </>
    )
}


const mapDispatchToProps = (dispatch)=> {
    return {
      onStartWorkout: (workoutActive) => dispatch(actions.startWorkout(workoutActive)),
      onEndWorkout: (id) => dispatch(actions.endWorkout(id))
    }
  }
  
  export default connect(null, mapDispatchToProps)(WorkoutDetail)
