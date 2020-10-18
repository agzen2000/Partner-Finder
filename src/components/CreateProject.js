import React, { useState } from 'react'
import ProjectOptions from "./ProjectOptions"
import SubmitArrow from "../assets/submit_arrow.svg"
import WavesIcon from "../assets/waves.svg"
import { Redirect } from 'react-router-dom'

function CreateProject() {
  const [optionsDisplayed, setOptionsDisplayed] = useState(false)
  const [optionsSelected, setOptionsSelected] = useState([])
  const [projectName, setProjectName] = useState("")
  const [redirect, setRedirect] = useState(false)

  const handleSubmit = async (e) => {
    e.preventDefault()
    const frmElements = e.target.elements
    const selected = []
    for (let i = 0; i < frmElements.length; i++) {
      const type = frmElements[i].type.toLowerCase()
      if (type === "checkbox" && frmElements[i].checked) {
        selected.push({ "name": frmElements[i].id })
      }
    }
    const res = await fetch("/api/project", {
                        method: 'POST',
                        body: JSON.stringify({
                          name: projectName,
                          skills: selected
                        }),
                        headers: {
                          'Content-Type': 'application/json',
                        }
                      })
    // const res.data
    setOptionsSelected(selected)
    // setRedirect(true)
  }

  return (
    redirect ? (
      <Redirect
        to={{
          pathname: "/results",
          skillsProp: optionsSelected
        }}
      ></Redirect>
    ) : (
      <form className="search" onSubmit={handleSubmit}>
        <div className="searchbar">
          <input
            className="searchbar__input"
            placeholder="e.g. Dubhacks 2020"
            onChange={(e) => setProjectName(e.target.value)}
            value={projectName}
          ></input>
          <button className="searchbar__submit" type="submit">
            Submit
            <img alt="submit" src={SubmitArrow}></img>
          </button>
        </div>
        <button
          className="search__toggle-filters"
          onClick={(e) => {
            e.preventDefault();
            setOptionsDisplayed(prev => !prev);
          }}
        >
          <p>Skills</p>
          <img src={WavesIcon} alt="radio waves"></img>
        </button>
        <ProjectOptions shouldShow={optionsDisplayed} hide={() => setOptionsDisplayed(false)} />
      </form>
    )
  )
}

export default CreateProject