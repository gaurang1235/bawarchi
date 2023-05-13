import React from 'react'
import RestaurantRegistrationForm from './RestaurantRegistration'

export default function FoodCourt(props) {
  return (
    <div><RestaurantRegistrationForm user = {props.user.authId}/></div>
  )
}
