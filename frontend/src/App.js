import logo from './logo.svg';
import './App.css';
import Header from "./Components/Header";
import HeroComponent from "./Components/HeroComponent";
import AboutComponent from "./Components/AboutComponent";
import ServicesComponent from "./Components/ServicesComponent";
import FearturesComponents from "./Components/FearturesComponents";
import Footer from "./Components/footer";

function App() {
  return (
    <div className="App">
      <Header />
      <HeroComponent />
      <AboutComponent />
      <ServicesComponent />
      <FearturesComponents />
      <Footer/>

    </div>
      );
}

export default App;
