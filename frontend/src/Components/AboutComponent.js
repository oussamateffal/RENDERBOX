import React from 'react';
import aboutbanner from '../images/about-banner.png';

function AboutComponent() {
    return (
        <section className="section about" id="about">
            <div className="container">

                <figure className="about-banner">
                    <img src={aboutbanner} width="700" height="532" loading="lazy" alt="about banner"
                         className="w-100 banner-animation"/>
                </figure>

                <div className="about-content">

                    <h2 className="h2 section-title underline">Why Our Agency</h2>

                    <p className="about-text">
                        A premier web and digital marketing agency from Saudi Arabia with over a
                        decade of experience. We craft visually captivating,
                        user-centric websites and offer tailored digital marketing
                        strategies to amplify your online presence.
                    </p>

                    <p className="about-text">
                        Whether you're a budding startup or an established name,
                        trust RenderBox for cutting-edge solutions and unparalleled service.
                    </p>

                    <ul className="stats-list">

                        <li className="stats-card">
                            <p className="h3 stats-title">+600</p>

                            <p className="stats-text">Satisfied Clients</p>
                        </li>

                        <li className="stats-card">
                            <p className="h3 stats-title">78</p>

                            <p className="stats-text">Project Lunched</p>
                        </li>

                        <li class="stats-card">
                            <p class="h3 stats-title">10</p>

                            <p class="stats-text">Years Completed</p>
                        </li>

                    </ul>

                </div>

            </div>
        </section>
    );
}

export default AboutComponent;
