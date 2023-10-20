import React from 'react';
import { FaFacebookF, FaInstagram,FaPhoneAlt ,FaTwitter } from 'react-icons/fa';
import {GrMail} from "react-icons/gr";

function Footer() {
    return (
        <footer class="footer">

            <div class="footer-top section">
                <div class="container">

                    <div class="footer-brand">

                        <a href="#" class="logo">RenderBox</a>

                        <p className="text">
                            Over 10 years of web and digital marketing excellence
                        </p>
                        <p className="text">
                            Your success in the digital realm starts with us                        </p>

                        <ul className="social-list">

                            <li>
                                <a href="#" className="social-link">
                                    <FaFacebookF />
                                </a>
                            </li>

                            <li>
                                <a href="#" className="social-link">
                                    <FaInstagram />
                                </a>
                            </li>

                            <li>
                                <a href="#" className="social-link">
                                    <FaTwitter />
                                </a>
                            </li>

                        </ul>

                    </div>

                    <ul class="footer-list">

                        <li>
                            <p class="footer-list-title">Our links</p>
                        </li>

                        <li>
                            <a href="#" class="footer-link">Home</a>
                        </li>

                        <li>
                            <a href="#" class="footer-link">About Us</a>
                        </li>

                        <li>
                            <a href="#" class="footer-link">Services</a>
                        </li>

                        <li>
                            <a href="#" class="footer-link">Our Values</a>
                        </li>

                        <li>
                            <a href="#" class="footer-link">Contact Us</a>
                        </li>

                    </ul>


                    <ul class="footer-list">

                        <li>
                            <p class="footer-list-title">Other links</p>
                        </li>

                        <li>
                            <a href="#" class="footer-link">FAQ</a>
                        </li>

                        <li>
                            <a href="#" class="footer-link">Portfolio</a>
                        </li>

                        <li>
                            <a href="#" class="footer-link">Privacy Policy</a>
                        </li>

                        <li>
                            <a href="#" class="footer-link">Terms & Conditions</a>
                        </li>

                        <li>
                            <a href="#" class="footer-link">Support</a>
                        </li>

                    </ul>

                    <ul class="footer-list">

                        <li>
                            <p class="footer-list-title">Contact Us</p>
                        </li>

                        <li class="footer-item">

                            <div class="footer-item-icon">
                                <ion-icon name="call"></ion-icon>
                                <FaPhoneAlt/>
                            </div>

                            <div>
                                <a href="tel:+2484214313" class="footer-item-link">+248-421-4313</a>
                                <a href="tel:+2486871365" class="footer-item-link">+248-687-1365</a>
                            </div>

                        </li>

                        <li class="footer-item">

                            <div class="footer-item-icon">
                                <ion-icon name="mail"></ion-icon>
                                <GrMail/>
                            </div>

                            <div>
                                <a href="mailto:info@desinic.com" class="footer-item-link">info@desinic.com</a>
                                <a href="mailto:help@desinic.com" class="footer-item-link">help@desinic.com</a>
                            </div>

                        </li>


                    </ul>

                </div>
            </div>

            <div class="footer-bottom">
                <p class="copyright">
                    &copy; 2023 <a href="#" class="copyright-link">coded by A&T Team</a>. All Right Reserved
                </p>
            </div>

        </footer>
    );
}

export default Footer;
