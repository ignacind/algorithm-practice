import React from 'react'
import './App.css'
import Die from './Die'
import { nanoid } from 'nanoid'
import Confetti from 'react-confetti'

export default function App() {
  const [allDices, setAllDices] = React.useState(allNewDice())
  const [tenzies, setTenzies] = React.useState(false)

  React.useEffect(() => {
    const num = allDices[0].value
    setTenzies(allDices.every(dice => dice.isHeld && (dice.value === num)));
    tenzies ? console.log("Felicitaciones") : null
  }, [allDices])


  function generateNewDie() {
    return ({
      value: Math.ceil(Math.random() * 6),
      isHeld: false,
      id: nanoid()
    })
  }

  function allNewDice() {
    const newDice = []
    for (let i = 0; i < 10; i++) {
      newDice.push(generateNewDie())
    }
    return newDice
  }

  function generateDice() {
    if (tenzies) {
      setTenzies(false)
      setAllDices(allNewDice())
    } else {
    setAllDices(oldDices => oldDices.map(dice => {
      return (
        dice.isHeld ? dice : generateNewDie())
    }))}
  }

  function beenPressed(id) {
    setAllDices(prevDices => prevDices.map(dice => {
      return (
        id === dice.id ? {...dice, isHeld: !dice.isHeld} : dice
      )
    }
    ))}
  

  const diceElements = allDices.map(dice =>  
    <Die 
    value={dice.value} 
    isHeld={dice.isHeld} 
    key={dice.id} 
    beenPressed={() => beenPressed(dice.id)} 

    />)


  const styles = {
    width: "120px"
  }


  return (
    <div className="app--container">
      {tenzies && <Confetti />}
      <h1>Tenzies</h1>
      <p>Roll until all dice are the same. Click each die to freeze it at its current value between rolls.</p>
      <div className="app--dices"> 
      {diceElements}
      </div>
      <button 
      style={tenzies ? styles: null}
      className="roll--btn" onClick={generateDice} >{tenzies ? 'New Game': 'Roll'}</button>
    </div>
  )
}

