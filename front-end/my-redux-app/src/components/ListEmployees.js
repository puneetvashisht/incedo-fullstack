import React, { useState } from 'react'
import { connect } from 'react-redux'


const ListEmployees =(props) =>{
  const listEmployees = props.employees.map((employee, i) => {
    return (
      <li key={i} className="list-group-item">{employee.name}</li>
    )
  })

  return (
    <ul className="list-group">
      {listEmployees}
    </ul>
  )
}

const mapStateToProps = (state)=> {
  console.log(state)
  return {
    employees: state.employees
  }
}

export default connect(mapStateToProps)(ListEmployees);
