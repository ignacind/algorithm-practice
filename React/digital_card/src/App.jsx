import './App.css'
import MainContent from './components/MainContent'
import Footer from './components/Footer';
import Header from './components/Header'
import React from 'react';

function App() {

  return (
    <div className='app--container'>
      <div className="app--container--two">
        <Header />
        <MainContent />
        <Footer />
      </div>
    </div>
  )
}

export default App;
