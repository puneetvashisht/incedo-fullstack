import * as actions from './workout-actions'
// create reducers to modify the state --- immutable

const initialState = {
    workouts: [
    ]
  }

const workoutActiverReducer = (state = initialState, action)=> {
    switch (action.type) {
        case actions.ADD_WORKOUT:
            //  state.workouts.push(action.payload)
            let newworkouts = [...state.workouts, action.payload]
            return {workouts: newworkouts}
        case actions.DELETE_WORKOUT:
                let remainingworkouts = state.workouts.filter((e)=>e.id!=action.payload.id)
                return {workouts: remainingworkouts}
        case actions.FETCH_WORKOUTS:
            return {workouts: action.payload}
        default:
            return {workouts: state.workouts};
    }
  }

  export default workoutActiverReducer;