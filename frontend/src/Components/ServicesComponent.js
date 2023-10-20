import React from 'react';
import { FaLaptopCode, FaPaintBrush,FaArrowRight ,FaCamera, FaVideo, FaFilm, FaBullhorn } from 'react-icons/fa';

function ServicesComponent() {
const services = [
        {
            title: "Web Development",
            description: "Crafting top-notch, custom websites tailored to your needs. Utilizing the latest tech for responsive, seamless browsing. From simple sites to intricate e-commerce platforms.",
            icon: <FaLaptopCode />
        },
        {
            title: "Design",
            description: "Delivering eye-catching designs to captivate your audience. Logos, branding, and graphics that echo your brand's voice. Helping you outshine competitors in the digital realm.",
            icon: <FaPaintBrush />
        },
        {
            title: "Photography",
            description: "Capturing your brand's essence through striking visuals. Detail-oriented shots for products, events, and more. Enhancing brand image with professional, quality imagery.",
            icon: <FaCamera />
        },
        {
            title: "Videography",
            description: "Crafting compelling videos to resonate with viewers. Promos, corporate reels, events, and impactful testimonials. Engaging storytelling to leave a lasting impression.",
            icon: <FaVideo />
        },
        {
            title: "Montage Video",
            description: "Transforming raw footage into polished visuals. Expert editing for a seamless, attractive end product. Coloring to align with brand aesthetics and mood.",
            icon: <FaFilm />
        },
        {
            title: "Digital Marketing",
            description: "Amplifying your online presence in a competitive space. Strategies spanning SEO, PPC, social media, and more. Tailored approaches to reach goals and boost visibility.",
            icon: <FaBullhorn />
        }
    ];

    return (
        <section className="section service" id="services">
            <div className="container">
                <h2 className="h2 section-title underline">Our Services</h2>
                <ul className="service-list">
                    {services.map((service, index) => (
                        <li key={index}>
                            <div className="service-card">
                                <div className="card-icon">{service.icon}</div>
                                <h3 className="h3 title">{service.title}</h3>
                                <p className="text">{service.description}</p>
                                <button className="card-btn" aria-label="Show More">
                                    <FaArrowRight className="arrow-icon" />
                                    <span className="btn-text">Portfolio</span>
                                </button>

                            </div>
                        </li>
                    ))}
                </ul>
            </div>
        </section>
    );
}

export default ServicesComponent;
