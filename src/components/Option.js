import React from 'react'

function Option({ name }) {
  return (
    <div className="option">
      <input type="checkbox"></input>
      <p>{name}</p>
    </div>
  )
}

export default Option
