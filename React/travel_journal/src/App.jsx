import './App.css';
import NavBar from './components/NavBar';
import Card from './components/Card';
import Travels from './DATA/places';


export default function App() { 
  
  const travelsList = Travels.map(Travel => {
    return (
      <Card {...Travel} key={Travel.id}/>
    )
  })

  return (
    <div className="app--container">
      <NavBar />
      <br /><br />
      <div className="app--container--travels">
        {travelsList}
      </div>
    

    </div>
  );
}
