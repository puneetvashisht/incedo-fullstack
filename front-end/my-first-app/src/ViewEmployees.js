import React, { useEffect, useState } from 'react'

export default function ViewEmployees() {

    const [employees, setEmployees] = useState([])

//   const employees = [
//     {id: 2, name: 'Ravi', salary: 33434.3},
//     {id: 12, name: 'Priya', salary: 43434.3},
//     {id: 3, name: 'Rajiv', salary: 23434.3}
//   ]

// substitue for componentDidMount
 useEffect(() => {
   //http call
    fetch('http://localhost:8000/employees/')
    .then(res=>res.json())
    .then(data=>{
        setEmployees(data)
    })
 }, [])
 

  const listEmployees = employees.map((employee, i)=> {
    return (
        <tr key={employee.id}>
        <th scope="row">{i+1}</th>
        <td>{employee.name}</td>
        <td>{employee.salary}</td>
        <td>@mdo</td>
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
