import './App.css'
import Card from './components/Card';
import MainContent from './components/MainContent';
import NavBar from './components/NavBar';
import Products from './data/products';

export default function App() {
  const productList = Products.map((product) => {
    return (
      <Card {...product} />
    );
  });

  return (
    <div className="app--container">
      <div className="app--container--two">
        <NavBar />
        <MainContent />
        <div className='app--container--product'>{productList}</div>
      </div>
    </div>
  );
}
