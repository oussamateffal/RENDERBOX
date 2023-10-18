import React from 'react';
import feartures from '../images/feautres-banner.png';
function FearturesComponents() {
    return (
        <section className="section features" id="features">
            <div className="container">

                <h2 className="h2 section-title underline">Our Features</h2>

                <ul className="features-list">

                    <li>
                        <div className="features-card">

                            <div className="icon">
                                <ion-icon name="bulb-outline"></ion-icon>
                            </div>

                            <div className="content">
                                <h3 className="h3 title">Idea & Analysis</h3>

                                <p className="text">
                                    Praesent tincidunt congue est ut hendrerit. Pellentesque et eros sit amet ipsum venenatis.
                                </p>
                            </div>

                        </div>
                    </li>

                    <li>
                        <div className="features-card">

                            <div className="icon">
                                <ion-icon name="color-palette-outline"></ion-icon>
                            </div>

                            <div className="content">
                                <h3 className="h3 title">Designing</h3>

                                <p className="text">
                                    Praesent tincidunt congue est ut hendrerit. Pellentesque et eros sit amet ipsum venenatis.
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
                                <ion-icon name="code-slash-outline"></ion-icon>
                            </div>

                            <div className="content">
                                <h3 className="h3 title">Development</h3>

                                <p className="text">
                                    Praesent tincidunt congue est ut hendrerit. Pellentesque et eros sit amet ipsum venenatis.
                                </p>
                            </div>

                        </div>
                    </li>

                    <li>
                        <div class="features-card">

                            <div class="icon">
                                <ion-icon name="rocket-outline"></ion-icon>
                            </div>

                            <div class="content">
                                <h3 class="h3 title">Testing & Lunching</h3>

                                <p class="text">
                                    Praesent tincidunt congue est ut hendrerit. Pellentesque et eros sit amet ipsum venenatis.
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
