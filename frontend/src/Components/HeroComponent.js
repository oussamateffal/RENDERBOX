import React from 'react';
import herobanner from '../images/photo1.png';
function HeroComponent() {
    return (
        <section className="hero" id="home">
            <div className="container">

                <div className="hero-content">

                    <p className="hero-subtitle">Welcome to RenderBox</p>

                    <h2 className="h2 hero-title">Over 10 years of web and digital marketing excellence</h2>

                    <p className="hero-text">
                        Your success in the digital realm starts with us
                    </p>

                    <button className="btn">Learn More</button>

                </div>

                <figure className="hero-banner">
                    <img src={herobanner} width="694" height="529" loading="lazy" alt="hero-banner"
                         className="w-100 banner-animation"/>
                </figure>

            </div>
        </section>
    );
}

export default HeroComponent;
