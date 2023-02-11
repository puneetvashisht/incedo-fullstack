export const ADD_EMPLOYEES = 'ADD_EMPLOYEES'
export const DELETE_EMPLOYEE = 'DELETE_EMPLOYEE'
export const FETCH_EMPLOYEES = 'FETCH_EMPLOYEES'

export const fetchEmployees = () => {
    console.log('fetching employees...');
    return (dispatch)=>{
        fetch('http://localhost:8080/employees/')
        .then(res=>res.json())
        .then(data=>{
            dispatch({type: FETCH_EMPLOYEES, payload: data})
        })
    } 
}

export const deleteEmployee = (id) => {
    // thunk
    return (dispatch)=> {
        fetch('http://localhost:8080/employees/' + id, {
            method: 'DELETE'
        })
        .then(res=>res.json())
        .then(data=>{
            // setEmployees(data)
            // let newEmployeeList = employees.filter((e) => e.id!= id);            
            dispatch({type: DELETE_EMPLOYEE, payload: {id}})
        })
    }
    


    // return {type: DELETE_EMPLOYEE, payload: {id}}
}

export const addEmployee = (employee) => {
    // return {type: ADD_EMPLOYEES, payload: employee}
    return (dispatch)=>{
        fetch('http://localhost:8080/employees', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(employee)

        })
        .then(res=>{
           dispatch({type: ADD_EMPLOYEES, payload: employee})
        });
    }
}
