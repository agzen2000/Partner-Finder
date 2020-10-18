import React, { useState } from 'react'
import SearchOptions from "./SearchOptions"
import SubmitArrow from "../assets/submit_arrow.svg"


function Search() {
  const [optionsDisplayed, setOptionsDisplayed] = useState(false)

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
        className="search-options-toggle"
        onClick={(e) => {
          e.preventDefault();
          setOptionsDisplayed(prev => !prev);
        }}
      ></button>
      <SearchOptions show={optionsDisplayed} />
    </form>
  )
}

export default Search
