import React from 'react'

function FeatureRow({ isReversed, heading, description, image }) {
  return (
    <div className={"feature" + (isReversed ? " feature--reversed" : "")}>
      <div>
        <div className="feature__heading">{heading}</div>
        <div className="feature__description">{description}</div>
      </div>
      <img src={image} alt="feature-img"></img>
    </div>
  )
}

export default FeatureRow
