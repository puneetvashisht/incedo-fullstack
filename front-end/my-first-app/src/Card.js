import React from 'react'
import Badge from './Badge'

export default function Card(props) {
  return (
    <div className="card" style={{width: '18rem'}}>
    <img src="https://via.placeholder.com/150" className="card-img-top" alt="..."/>
    <div className="card-body">
        <h5 className="card-title">{props.title}</h5>
        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <Badge caption="Votes"></Badge>
    </div>
    </div>
  )
}
