import * as actions from './workout-active-actions'
// create reducers to modify the state --- immutable

const initialState = {
  workoutActive: [
  ]
}

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case actions.START_WORKOUT:
      //  state.workouts.push(action.payload)
      let newworkouts = [...state.workoutActive, action.payload]
      return { workoutActive: newworkouts }

    case actions.END_WORKOUT:
      //  state.workouts.push(action.payload)
      // let newworkouts = [...state.workoutActive, action.payload]
      return { workoutActive: state.workoutActive }
    case actions.FETCH_ACTIVE_WORKOUTS:
        return {workoutActive: action.payload}
    default:
      return { workoutActive: state.workoutActive };
  }
}

export default reducer;