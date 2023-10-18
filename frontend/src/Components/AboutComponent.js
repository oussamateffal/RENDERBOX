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
                        In dictum aliquam turpis lacinia iaculis. Fusce vel malesuada magna. Nulla vel maximus risus. Donec
                        volutpat metus
                        lacinia risus accumsan, ac bibendum libero efficitur. Pellentesque nec nisi sit amet magna tempus
                        hendrerit ut a odio.
                    </p>

                    <p className="about-text">
                        Praesent rhoncus commodo tortor, id pulvinar nisl blandit at. Nulla facilisi. Quisque turpis ante,
                        vehicula condimentum
                        arcu.
                    </p>

                    <ul className="stats-list">

                        <li className="stats-card">
                            <p className="h3 stats-title">9875</p>

                            <p className="stats-text">Satisfied Clients</p>
                        </li>

                        <li className="stats-card">
                            <p className="h3 stats-title">7894</p>

                            <p className="stats-text">Project Lunched</p>
                        </li>

                        <li class="stats-card">
                            <p class="h3 stats-title">65</p>

                            <p class="stats-text">Years Completed</p>
                        </li>

                    </ul>

                </div>

            </div>
        </section>
    );
}

export default AboutComponent;
