export const START_WORKOUT = 'START_WORKOUT'
export const END_WORKOUT = 'END_WORKOUT'
export const FETCH_ACTIVE_WORKOUTS = 'FETCH_ACTIVE_WORKOUTS'


const BASE_URL = 'http://localhost:8080/workoutactive/'

export const fetchWorkouts = () => {
    console.log('fetching employees...');
    return (dispatch)=>{
        fetch(BASE_URL)
        .then(res=>res.json())
        .then(data=>{
            dispatch({type: FETCH_ACTIVE_WORKOUTS, payload: data})
        })
    } 
}

export const startWorkout = (workoutActive) => {
    // return {type: ADD_WORKOUTS, payload: employee}
    return (dispatch)=>{
        fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(workoutActive)

        })
        .then(res=>{
           dispatch({type: START_WORKOUT, payload: workoutActive})
        });
    }
}

export const endWorkout = (id) => {
    // return {type: ADD_WORKOUTS, payload: employee}
    return (dispatch)=>{
        fetch(BASE_URL + 'end/' + id, {
            method: 'PATCH',
            headers: {
                'Content-type': 'application/json'
            }

        })
        .then(res=>{
           dispatch({type: END_WORKOUT})
        });
    }
}   