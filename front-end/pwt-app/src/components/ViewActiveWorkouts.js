import React, { useEffect, useState } from 'react'

import Autohide from './Autohide';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';

import * as actions from '../store/workout-active-actions'
import { Button } from 'react-bootstrap';



const ViewActiveWorkouts = (props) => {

    // For state initialization use useState hook
    // const [workouts, setWorkouts] = useState([]);
    const [showStatus, setShowStatus]= useState(false);

    // For component mounting use.. useEffect hook
    useEffect(() => {
        // console.log('Called up after component is mounted and running');
        // fetch('http://localhost:8080/workouts/')
        //     .then(res => res.json())
        //     .then(data => {
        //         console.log(data);
        //         setWorkouts(data);
        //     })
        props.onFetchWorkoutActive();
    }, [])



    return (
        <div className="container">

            <div className="row">


                {showStatus && <Autohide message="Workout is deleted"></Autohide>}

                <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Workout Title</th>
                            <th scope="col">Start Time</th>
                            
                            <th scope="col">End Workout</th>
                            <th scope="col">End Time</th>
                            <th scope="col">Total Burnt</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            props.workoutActives.map((workoutActive, i) => {
                                return (<tr key={i}>
                                    <th scope="row">{i + 1}</th>
                                    <td>{workoutActive.workout.title}</td>
                                    <td>{workoutActive?.startTime}</td>
                                    <td>{!workoutActive?.endTime && <Button onClick={()=>props.onEndWorkout(workoutActive.id)} variant="primary">End Workout</Button>}</td>
                                    <td>{workoutActive?.endTime}</td>
                                    <td>Total Calories Burnt</td>
                                   
                                </tr>);
                            })
                        }
                    </tbody>
                </table>
            </div>

            
        </div>
    )

}

const mapStateToProps = (state)=> {
    console.log(state)
    return {
      workoutActives: state.workoutActiverReducer.workoutActive
    }
  }
  
  const mapDispatchToProps = (dispatch)=> {
    return {
      onFetchWorkoutActive: ()=>dispatch(actions.fetchWorkouts()),
      onEndWorkout: (id) => dispatch(actions.endWorkout(id))
    }
  }
  
  export default connect(mapStateToProps, mapDispatchToProps)(ViewActiveWorkouts)

// export default ViewWorkouts;
