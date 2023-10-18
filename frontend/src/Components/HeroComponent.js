import React from 'react';
import herobanner from '../images/hero-banner.png';
function HeroComponent() {
    return (
        <section className="hero" id="home">
            <div className="container">

                <div className="hero-content">

                    <p className="hero-subtitle">We Are Product Designer From UK</p>

                    <h2 className="h2 hero-title">We Design Interfaces That Users Love</h2>

                    <p className="hero-text">
                        Morbi sed lacus nec risus finibus feugiat et fermentum nibh. Pellentesque vitae ante at elit fringilla ac
                        at purus.
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
