import React from 'react'
import vehicles from '../data/vehicles'
import './VehicleView.css'

function VehiclesViews({vehicle}) {
  return (
    <div className='VehicleViewC'>
        <h1>{vehicle.name}</h1>
        <h2>{vehicle.description}</h2>
        <img src={vehicle.image} alt={"Image of " + vehicle.name} />
    </div>
  )
}

export default VehiclesViews