import React from 'react'

export default function Clock(props) {
  return (
    <h2>Time : {props.today.getHours()} : {props.today.getMinutes()} : {props.today.getSeconds()}</h2>
  )
}
