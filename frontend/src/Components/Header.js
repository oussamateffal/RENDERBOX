import React, { useState, useEffect } from 'react';

function Header() {
    // État pour le menu ouvert/fermé
    const [isMenuOpen, setMenuOpen] = useState(false);
    const [isHeaderActive, setHeaderActive] = useState(false);

    useEffect(() => {
        const handleScroll = () => {
            if (window.scrollY >= 400) {
                setHeaderActive(true);
            } else {
                setHeaderActive(false);
            }
        };

        window.addEventListener('scroll', handleScroll);

        // Nettoyage de l'écouteur d'événements au démontage du composant
        return () => window.removeEventListener('scroll', handleScroll);
    }, []);

    const toggleMenu = () => {
        setMenuOpen(!isMenuOpen);
    };

    return (
        <header className={`header ${isHeaderActive ? 'active' : ''}`} data-header>
            <div className="container">
                <div className={`overlay ${isMenuOpen ? 'active' : ''}`} data-overlay onClick={toggleMenu}></div>
                <a href="#">
                    <h1 className="logo">RenderBox</h1>
                </a>
                <nav className={`navbar ${isMenuOpen ? 'active' : ''}`} data-navbar>
                    <div className="navbar-top">
                        <a href="#" className="logo">RenderBox</a>
                        <button
                            className="nav-close-btn"
                            aria-label="Close Menu"
                            data-nav-close-btn
                            onClick={toggleMenu}>
                            <ion-icon name="close-outline"></ion-icon>
                        </button>
                    </div>
                    <ul className="navbar-list">
                        <li className="navbar-item">
                            <a href="#home" className="navbar-link" data-navbar-link onClick={toggleMenu}>Home</a>
                        </li>
                        <li className="navbar-item">
                            <a href="#about" className="navbar-link" data-navbar-link onClick={toggleMenu}>About</a>
                        </li>
                        <li className="navbar-item">
                            <a href="#services" className="navbar-link" data-navbar-link onClick={toggleMenu}>Services</a>
                        </li>
                        <li className="navbar-item">
                            <a href="#features" className="navbar-link" data-navbar-link onClick={toggleMenu}>Our Values</a>
                        </li>
                        <li className="navbar-item">
                            <a href="#" className="navbar-link" data-navbar-link onClick={toggleMenu}>Contact Us</a>
                        </li>
                    </ul>
                </nav>
                <a href="#" className="btn">
                    <ion-icon name="chevron-forward-outline" aria-hidden="true"></ion-icon>
                    <span>Start Chat</span>
                </a>
                <button
                    className="nav-open-btn"
                    aria-label="Open Menu"
                    data-nav-open-btn
                    onClick={toggleMenu}>
                    <ion-icon name="menu-outline"></ion-icon>
                </button>
            </div>
        </header>
    );
}

export default Header;
