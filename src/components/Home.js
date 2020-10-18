import React from 'react'
import Logo from "../assets/Logo.svg"
import HeroImage from "../assets/Brainstorming.png"
import Search from './Search'

function Home() {
  return (
    <div className="home">
      <div className="home__header">
        <img className="home__logo" src={Logo} alt="peer finder logo"></img>
      </div>
      <main className="home__main">
        <div className="home__hero">
          <h3 className="home__title">This is Peer Finder</h3>
          <p className="home__description">
            Have you ever encountered a difficulty with choosing a film or TV show to watch or where to even stream them. Well you’ve come to the right place, moodvie does that for you.
          </p>
          <Search />
          <img className="home__hero-image" src={HeroImage} alt="hero"></img>
        </div>
        <div className="home__features"></div>
      </main>
      <footer className="home__footer"></footer>
    </div>
  )
}

export default Home
