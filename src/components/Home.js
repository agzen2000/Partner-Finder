import React from 'react'
import Logo from "../assets/Logo.svg"
import HeroImage from "../assets/Brainstorming.png"
import CreateProject from './CreateProject'
import ThinkingIcon from "../assets/Feature-Thinking.svg"
import FeatureRow from './FeatureRow'
import Feature1Icon from "../assets/Feature-1.svg"
import Feature2Icon from "../assets/Feature-2.svg"
import Feature3Icon from "../assets/Feature-3.png"


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
            Have you ever encountered a difficulty with finding teammates for your project or hackathon idea? Well you’ve come to the right place, Peer Finder does that for you.
          </p>
          <CreateProject />
          <img className="home__hero-image" src={HeroImage} alt="hero"></img>
        </div>
        <div className="home__features">
          <img className="home__thinking-icon" src={ThinkingIcon} alt="thinking emoji"></img>
          <h3 className="home__question">How does Peer Finder work?</h3>
          <FeatureRow
            isReversed={false}
            heading="01 Your Mood"
            description="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed do eiusmod tempor."
            image={Feature1Icon}
          />
          <FeatureRow
            isReversed={true}
            heading="02 Our Algorithm"
            description="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed do eiusmod tempor."
            image={Feature2Icon}
          />
          <FeatureRow
            isReversed={false}
            heading="03 A Wide Array of Suggestions"
            description="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed do eiusmod tempor."
            image={Feature3Icon}
          />
        </div>
      </main>
      <footer className="home__footer">
        <p className="home__remark">Designed and developed in beautiful Seattle, WA 🏔</p>
        <button className="home__footer-btn">Help</button>
        <button className="home__footer-btn">Feedback</button>
      </footer>
    </div>
  )
}

export default Home
