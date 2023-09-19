import './App.css';
import Card from './components/Card'
import vehicles from './data/vehicles';
import ShowHide from './components/ShowHide';

function App() {
  const vehicleList = vehicles.map(v => {
    return <Card title={v.name} description={v.description} />
  
    })
  return (
      <div className='App'>
        <h1>Hola Reacta</h1>
        <div className='container'>
        {vehicleList}
        <ShowHide />
        <img src='src/imgs/images.png' alt='asdasdasdasdasdasdass' />
          </div>
      </div>
  );
}

export default App;
