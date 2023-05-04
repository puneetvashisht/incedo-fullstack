import React, { useEffect, useState } from 'react'

import Autohide from './Autohide';
import { Link } from 'react-router-dom';


const ViewWorkouts = () => {

    // For state initialization use useState hook
    const [workouts, setWorkouts] = useState([]);
    const [showStatus, setShowStatus]= useState(false);

    // For component mounting use.. useEffect hook
    useEffect(() => {
        console.log('Called up after component is mounted and running');
        fetch('http://localhost:8080/workouts/')
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setWorkouts(data);
            })
    }, [])

    const deleteWorkout = (id) =>{
        fetch('http://localhost:8080/workouts/' + id,{
            method: 'DELETE'
        })
        .then(res => {
            setShowStatus(true);
        })
        
    }

    return (
        <div className="container">

            <div className="row">


                {showStatus && <Autohide message="Workout is deleted"></Autohide>}

                <table className="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Workout Title</th>
                            <th scope="col">Category</th>
                            <th scope="col">Calories Burnt Per Miniute(cbpm)</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            workouts.map((workout, i) => {
                                return (<tr key={i}>
                                    <th scope="row">{i + 1}</th>
                                    <td><Link to={'/edit/' + workout.id}>{workout.title}</Link></td>
                                    <td>{workout.category?.title}</td>
                                    <td>{workout.cbpm}</td>
                                    <td><button onClick={()=>deleteWorkout(workout.id)} className='btn btn-danger'>X</button></td>
                                </tr>);
                            })
                        }
                    </tbody>
                </table>
            </div>

            
        </div>
    )

}
export default ViewWorkouts;
