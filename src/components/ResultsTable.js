import React from 'react'

function ResultsTable({ results }) {
  return (
    <table className="results__table">
      <thead>
        <tr className="results__row">
          <th>Name</th>
          <th>Skills</th>
          <th>Contact Info</th>
          <th>Description</th>
          <th>Remove</th>
        </tr>
        <tbody>
          <tr className="results__row">
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
    </table>
  )
}

export default ResultsTable
