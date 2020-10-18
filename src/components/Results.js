import React from 'react'
import Logo from "../assets/Logo.svg"
import HeroImage from "../assets/Brainstorming.png"
import Search from './Search'

function Results() {
  return (
    <div className="results">
      <div className="home__header">
        <img className="home__logo" src={Logo} alt="peer finder logo"></img>
      </div>
      <main className="results__main">
        <div className="results__hero">
          <h3 className="results__title">Dubhacks2020</h3>
          {/* <Table striped bordered hover> */}
            <thead>
              <tr>
                <th>Name</th>
                <th>Skills</th>
                <th>Contact Info</th>
                <th>Description</th>
                <th>Remove</th>
              </tr>
              <tbody>
                <tr>
                  <td>John Doe</td>
                  <td>Front-end Developer, UI Design</td>
                  <td>johndoe@uw.edu</td>
                  <td>Hi, I'm John, I'm a Front-end Developer. I'm currently a junior at the University of Washington...</td>
                </tr>
                <tr>
                  <td>Text</td>
                  <td>Text</td>
                  <td>Text</td>
                  <td>Text</td>
                </tr>
              </tbody>
            </thead>
          {/* </Table> */}
        </div>
      </main>
    </div>
  )
}

export default Results
