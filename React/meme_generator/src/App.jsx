import './App.css';
import MainContent from './components/MainContent';
import NavBar from './components/NavBar';

export default function App() {
  return (
    <div className="app--container">
      <NavBar />
      <MainContent />
    </div>
  );
}