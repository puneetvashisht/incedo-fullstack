import React, { useState } from 'react'
import Button from 'react-bootstrap/Button';
import Autohide from './Autohide';
import { connect } from 'react-redux';
import * as actions from '../store/workout-actions'

const AddWorkout = (props) =>  {

    const [title, setTitle] = useState('')
    const [cbpm, setCbpm] = useState()
    const [showStatus, setShowStatus]= useState(false);


    // const addWorkout = () => {
    //     console.log({title, cbpm});

    //     // fetch('http://localhost:8080/workouts/', {
    //     //     method: 'POST',
    //     //     headers: {
    //     //         'Content-type': 'application/json'
    //     //     },
    //     //     body: JSON.stringify({title, cbpm, category: {title: "Cardio"}})
    //     // })
    //     // .then(res=> {
    //     //     if(res.status === 201){
    //     //         setShowStatus(true);
    //     //     }
    //     // })
    // }

    return (
        <>
        {showStatus && <Autohide message="Workout is added!"></Autohide>}
            <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">Title</span>
                <input type="text" onChange={(e)=> setTitle(e.target.value)} value={title} className="form-control" placeholder="Enter Title" aria-label="Username" aria-describedby="basic-addon1" />
            </div>
            <div className="input-group mb-3">
                <span className="input-group-text" id="basic-addon1">Calories Burnt(per minute)</span>
                <input type="number" onChange={(e)=> setCbpm(e.target.value)} value={cbpm} className="form-control" placeholder="Enter CBPM" aria-label="Username" aria-describedby="basic-addon1" />
            </div>
            <div className="input-group mb-3">
                <Button onClick={()=>props.onAddWorkout({title, cbpm,category: {title: "Cardio"}})} variant="primary">Add Workout</Button>
            </div>
        </>
    )
}

const mapDispatchToProps = (dispatch)=> {
    return {
      onAddWorkout: (workout) => dispatch(actions.addWorkout(workout))
    }
  }
  
  export default connect(null, mapDispatchToProps)(AddWorkout)
