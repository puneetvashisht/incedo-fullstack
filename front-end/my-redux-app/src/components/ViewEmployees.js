
import React from 'react'
import { connect } from 'react-redux'

const ViewEmployees= (props) => {



 const deleteEmployee = (id)=>{
        // let newEmployeeList = employees.filter((e) => e.id!= id);
        // setEmployees(newEmployeeList)
 }

  const listEmployees = props.employees.map((employee, i)=> {
    return (
        <tr key={i}>
        <th scope="row">{i+1}</th>
        <td>{employee.name}</td>
        <td>{employee.salary}</td>
        <td><button onClick={()=>props.onDeleteEmployees(employee.id)} className='btn btn-danger'>X</button></td>
        </tr>
    )
  })

  return (
    <table className="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
  {listEmployees}
  </tbody>
</table>
  )
}


const mapStateToProps = (state)=> {
  console.log(state)
  return {
    employees: state.employees
  }
}

const mapDispatchToProps = (dispatch)=> {
  return {
    onDeleteEmployees: (id) => dispatch({type: 'DELETE_EMPLOYEE', payload: {id}})
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(ViewEmployees)
