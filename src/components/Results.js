import React, { useState } from 'react'
import SearchIcon from "../assets/search.svg"
import Logo from "../assets/Logo.svg"
import HeroImage from "../assets/Brainstorming.png"
import CreateProject from './CreateProject'
import ResultsTable from './ResultsTable'

function Results({ location: { skillsProp = [] } }) {
  const [skills, setSkills] = useState(skillsProp)
  console.log(skillsProp)
  return (
    <div className="results">
      <div className="home__header">
        <img className="home__logo" src={Logo} alt="peer finder logo"></img>
      </div>
      <div className="results__sub-header">
        <h3 className="results__sub-header-title">Dubhacks 2020</h3>
        {skills.map((skill, key) => (
          <div id={skill} className="skill">{skill}</div>
        ))}
      </div>
      <main className="results__main">
        <div className="searchbar">
          <input className="searchbar__input" placeholder="e.g. Dubhacks 2020"></input>
          <button className="searchbar__submit" type="submit">
            Submit
            <img alt="submit" src={SearchIcon}></img>
          </button>
        </div>
        <ResultsTable />
      </main>
    </div>
  )
}

export default Results
