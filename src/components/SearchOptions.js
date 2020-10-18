import React from 'react'
import Option from "./Option"


function SearchOptions({ show }) {
  const options = ["Front-end Development, Back-end Development", "Full-stack Development", "Data Analysis", "Data Science", "User-Centered Design", "Rapid Prototyping", "UX Research", "Usability Testing", "Security Engineering", "Adobe Creative Suite", "Agile Methods", "Data Structures", "Algorithms", "Project Management", "Machine Learning", "XR/VR", "Graphic Design", "Other"]

  return (
    show ? (
      <div className="search-options-overlay">
        {options.map(option => (
          <Option name={option} />
        ))}
      </div>
    ) : (
      null
    )
  )
}

export default SearchOptions