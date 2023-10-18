import React from 'react';

function Header() {
    return (
        <header className="header" data-header>
            <div className="container">
                <div className="overlay" data-overlay></div>
                <a href="#">
                    <h1 className="logo">RenderBox</h1>
                </a>
                <nav className="navbar" data-navbar>
                    <div className="navbar-top">
                        <a href="#" className="logo">Desinic</a>
                        <button className="nav-close-btn" aria-label="Close Menu" data-nav-close-btn>
                            <ion-icon name="close-outline"></ion-icon>
                        </button>
                    </div>
                    <ul className="navbar-list">
                        <li className="navbar-item">
                            <a href="#home" className="navbar-link" data-navbar-link>Home</a>
                        </li>
                        <li className="navbar-item">
                            <a href="#about" className="navbar-link" data-navbar-link>About</a>
                        </li>
                        <li className="navbar-item">
                            <a href="#services" className="navbar-link" data-navbar-link>Services</a>
                        </li>
                        <li className="navbar-item">
                            <a href="#features" className="navbar-link" data-navbar-link>Features</a>
                        </li>
                        <li className="navbar-item">
                            <a href="#blog" className="navbar-link" data-navbar-link>Blog</a>
                        </li>
                        <li className="navbar-item">
                            <a href="#" className="navbar-link" data-navbar-link>Contact Us</a>
                        </li>
                    </ul>
                </nav>
                <a href="#" className="btn">
                    <ion-icon name="chevron-forward-outline" aria-hidden="true"></ion-icon>
                    <span>Get A Quote</span>
                </a>
                <button className="nav-open-btn" aria-label="Open Menu" data-nav-open-btn>
                    <ion-icon name="menu-outline"></ion-icon>
                </button>
            </div>
        </header>
    );
}

export default Header;
