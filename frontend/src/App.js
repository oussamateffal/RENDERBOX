import logo from './logo.svg';
import './App.css';
import Header from "./Components/Header";
import HeroComponent from "./Components/HeroComponent";
import AboutComponent from "./Components/AboutComponent";
import ServicesComponent from "./Components/ServicesComponent";
import FearturesComponents from "./Components/FearturesComponents";
import Footer from "./Components/footer";
import ChatCard from "./Components/ChatCard";
import {useState} from "react";

function App() {
    const [isChatCardVisible, setChatCardVisible] = useState(false);

  return (
    <div className="App">
        <Header openChat={() => setChatCardVisible(true)} />
        <ChatCard showPopup={isChatCardVisible} closeChat={() => setChatCardVisible(false)} />
      <HeroComponent />
      <AboutComponent />
      <ServicesComponent />
      <FearturesComponents />
        <ChatCard/>
      <Footer/>

    </div>
      );
}

export default App;
