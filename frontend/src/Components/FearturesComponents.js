import React from 'react';
import feartures from '../images/feautres-banner.png';

function FearturesComponents() {
    return (
        <section className="section features" id="features">
            <div className="container">

                <h2 className="h2 section-title underline">Our Values</h2>

                <ul className="features-list">

                    <li>
                        <div className="features-card">
                            <div className="icon">
                                <ion-icon name="bulb-outline"></ion-icon>
                                <span className="icon-number">{1}</span>

                            </div>
                            <div className="content">
                                <h3 className="h3 title">Excellence</h3>
                                <p className="text">
                                    We strive for the highest quality, exceeding client expectations.
                                </p>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div className="features-card">
                            <div className="icon">
                                <ion-icon name="shield-checkmark-outline"></ion-icon>
                                <span className="icon-number">{2}</span>
                            </div>
                            <div className="content">
                                <h3 className="h3 title">Integrity</h3>
                                <p className="text">
                                    We prioritize honesty, transparency, and ethical practices.
                                </p>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div className="features-card">
                            <div className="icon">
                                <ion-icon name="flask-outline"></ion-icon>
                                <span className="icon-number">{3}</span>
                            </div>
                            <div className="content">
                                <h3 className="h3 title">Innovation</h3>
                                <p className="text">
                                    We embrace creativity and novel solutions.
                                </p>
                            </div>
                        </div>
                    </li>
                    </ul>
                    <figure className="features-banner">
                        <img src={feartures} width="369" height="318" loading="lazy" alt="Features Banner"
                             className="w-100 banner-animation"/>
                    </figure>
                <ul className="features-list">
                    <li>
                        <div className="features-card">
                            <div className="icon">
                                <ion-icon name="people-outline"></ion-icon>
                                <span className="icon-number">{4}</span>
                            </div>
                            <div className="content">
                                <h3 className="h3 title">Collaboration</h3>
                                <p className="text">
                                    Teamwork and client alignment drive our success.
                                </p>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div className="features-card">
                            <div className="icon">
                                <ion-icon name="heart-outline"></ion-icon>
                                <span className="icon-number">{5}</span>
                            </div>
                            <div className="content">
                                <h3 className="h3 title">Customer-Centricity</h3>
                                <p className="text">
                                    Clients are at the core of our endeavors.
                                </p>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div className="features-card">
                            <div className="icon">
                                <ion-icon name="sync-outline"></ion-icon>
                                <span className="icon-number">{6}</span>
                            </div>
                            <div className="content">
                                <h3 className="h3 title">Adaptability</h3>
                                <p className="text">
                                    We're agile in the ever-evolving digital landscape.
                                </p>
                            </div>
                        </div>
                    </li>

                </ul>


            </div>
        </section>
    );
}

export default FearturesComponents;
