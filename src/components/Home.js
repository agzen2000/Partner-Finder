import React from 'react'
import Logo from "../assets/Logo.svg"


function Home() {
  return (
    <div className="home">
      <img className="home__header" src={Logo}></img>
      <main className="home__main">
        <div className="home__top"></div>
        <div className="home__bottom"></div>
      </main>
      <footer className="home__footer"></footer>
    </div>
  )
}

export default Home
