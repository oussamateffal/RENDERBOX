import React from 'react';

function ServicesComponent() {
    return (
        <section className="section service" id="services">
            <div className="container">

                <h2 className="h2 section-title underline">Our Speciallization</h2>

                <ul className="service-list">

                    <li>
                        <div className="service-card">

                            <div className="card-icon">
                                <ion-icon name="telescope-outline"></ion-icon>
                            </div>

                            <h3 className="h3 title">Strategy & Research</h3>

                            <p className="text">
                                Mauris ut felis malesuada eros varius tristique a at orci. Nulla vulputate, leo sit amet rhoncus
                                suscipit, enim ex
                                venenatis ipsum, et porttitor.
                            </p>

                            <button className="card-btn" aria-label="Show More">
                                <ion-icon name="chevron-forward-outline"></ion-icon>
                            </button>

                        </div>
                    </li>

                    <li>
                        <div className="service-card">

                            <div className="card-icon">
                                <ion-icon name="desktop-outline"></ion-icon>
                            </div>

                            <h3 className="h3 title">Web Development</h3>

                            <p className="text">
                                Mauris ut felis malesuada eros varius tristique a at orci. Nulla vulputate, leo sit amet rhoncus
                                suscipit, enim ex
                                venenatis ipsum, et porttitor.
                            </p>

                            <button className="card-btn" aria-label="Show More">
                                <ion-icon name="chevron-forward-outline"></ion-icon>
                            </button>

                        </div>
                    </li>

                    <li>
                        <div className="service-card">

                            <div className="card-icon">
                                <ion-icon name="globe-outline"></ion-icon>
                            </div>

                            <h3 className="h3 title">Web Solution</h3>

                            <p className="text">
                                Mauris ut felis malesuada eros varius tristique a at orci. Nulla vulputate, leo sit amet rhoncus
                                suscipit, enim ex
                                venenatis ipsum, et porttitor.
                            </p>

                            <button class="card-btn" aria-label="Show More">
                                <ion-icon name="chevron-forward-outline"></ion-icon>
                            </button>

                        </div>
                    </li>

                </ul>

            </div>
        </section>



    );
}

export default ServicesComponent;
