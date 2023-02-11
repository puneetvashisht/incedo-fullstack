import * as actions from './employee-actions'
// create reducers to modify the state --- immutable

const initialState = {
    employees: [
    ]
  }

const reducer = (state = initialState, action)=> {
    switch (action.type) {
        case actions.ADD_EMPLOYEES:
            //  state.employees.push(action.payload)
            let newEmployees = [...state.employees, action.payload]
            return {employees: newEmployees}
        case actions.DELETE_EMPLOYEE:
                let remainingEmployees = state.employees.filter((e)=>e.id!=action.payload.id)
                return {employees: remainingEmployees}
        case actions.FETCH_EMPLOYEES:
            return {employees: action.payload}
        default:
            return {employees: state.employees};
    }
  }

  export default reducer;