import React from 'react'
import CloseIcon from "../assets/close.svg"
import OptionColumn from './OptionColumn'


function SearchOptions({ hide, shouldShow }) {
  const options = ["Front-end Development", "Back-end Development", "Full-stack Development", "Data Analysis", "Data Science", "User-Centered Design", "Rapid Prototyping", "UX Research", "Usability Testing", "Security Engineering", "Adobe Creative Suite", "Agile Methods", "Data Structures", "Algorithms", "Project Management", "Machine Learning", "XR/VR", "Graphic Design", "Other"]

  return (
      <div className={"overlay" + (!shouldShow ? " overlay--hidden" : "")}>
        <div className="overlay__header">
          <h5 className="overlay__title">Applicable Skills <span>(check all that apply)</span></h5>
          <img src={CloseIcon} onClick={hide} alt="close"></img>
        </div>
        <div className="overlay__body">
          <OptionColumn colNum={1} options={options.slice(0, options.length / 3)} />
          <OptionColumn colNum={2} options={options.slice(options.length / 3, options.length * 2 / 3)} />
          <OptionColumn colNum={3} options={options.slice(options.length * 2 / 3,)} />
        </div>
      </div>
  )
}

export default SearchOptions