import React from 'react'

export default function DropdownItem(props) {
  return (
    <li><a onClick={()=>props.onItemChange(props.cuisine)} className="dropdown-item" href="#">{props.cuisine}</a></li>
  )
}
