import React from 'react'

function Option({ name }) {
  return (
    <div className="option">
      <input id={name} type="checkbox"></input>
      <p className="option__name">{name}</p>
    </div>
  )
}

export default Option
