const redux = require('redux')
const initialState = {
    employees: [
        {id: 1, name: "Ravi", salary: 34343},
        {id: 2, name: "Priya", salary: 44343},
    ]
}
// create reducers to modify the state --- immutable
const reducer = (state = initialState, action)=> {
    switch (action.type) {
        case 'ADD_EMPLOYEES':
            //  state.employees.push(action.payload)
            let newEmployees = [...state.employees, action.payload]
            return {employees: newEmployees}
        case 'DELETE_EMPLOYEE':
                let remainingEmployees = state.employees.filter((e)=>e.id!=action.payload.id)
                return {employees: remainingEmployees}
        default:
            return {employees: state.employees};
    }
}

// create store (all the state)
const store = redux.createStore(reducer)

store.subscribe(()=> console.log(store.getState()))
// dispatch action
// const deleteAction = {type: 'DELETE_EMPLOYEE', payload: {id: 2}}
const fetchAction = {type:'FETCH_EMPLOYEES'}
store.dispatch(fetchAction)
// store.dispatch({type: 'ADD_EMPLOYEES', payload: {id: 3, name: "Harshit", salary: 22222}})