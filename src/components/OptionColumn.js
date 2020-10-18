import React from 'react'
import Option from "./Option"


function OptionColumn({ colNum, options }) {
  return (
    <div className={`overlay__col${colNum}`}>
      {options.map((option, key) => (<Option key={key} name={option} />))}
    </div>
  )
}

export default OptionColumn