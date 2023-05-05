export const ADD_WORKOUT = 'ADD_WORKOUT'
export const DELETE_WORKOUT = 'DELETE_WORKOUT'
export const FETCH_WORKOUTS = 'FETCH_WORKOUTS'

const BASE_URL = 'http://localhost:8080/workouts/'

export const fetchWorkouts = () => {
    console.log('fetching employees...');
    return (dispatch)=>{
        fetch(BASE_URL)
        .then(res=>res.json())
        .then(data=>{
            dispatch({type: FETCH_WORKOUTS, payload: data})
        })
    } 
}

export const deleteWorkout = (id) => {
    // thunk
    return (dispatch)=> {
        fetch(BASE_URL + id, {
            method: 'DELETE'
        })
        .then(res=>{
            console.log(res.status)
            dispatch({type: DELETE_WORKOUT, payload: {id}})
        })
        // .then(data=>{
        //     // setEmployees(data)
        //     // let newEmployeeList = employees.filter((e) => e.id!= id);            
            
        // })
    }
    


    // return {type: DELETE_WORKOUT, payload: {id}}
}

export const addWorkout = (workout) => {
    // return {type: ADD_WORKOUTS, payload: employee}
    return (dispatch)=>{
        fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(workout)

        })
        .then(res=>{
           dispatch({type: ADD_WORKOUT, payload: workout})
        });
    }
}
