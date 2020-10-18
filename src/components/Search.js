import React, { useState } from 'react'
import SearchOptions from "./SearchOptions"
import SubmitArrow from "../assets/submit_arrow.svg"
import WavesIcon from "../assets/waves.svg"

function Search() {
  const [optionsDisplayed, setOptionsDisplayed] = useState(false)
  // const handleSubmit = (e) => {
  //   e.target.children.querySele
  // }

  return (
    <form className="search">
      <div className="searchbar">
        <input className="searchbar__input" placeholder="e.g. Dubhacks 2020"></input>
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
      <SearchOptions shouldShow={optionsDisplayed} hide={() => setOptionsDisplayed(false)} />
    </form>
  )
}

export default Search