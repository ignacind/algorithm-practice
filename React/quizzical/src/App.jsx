import React from "react";
import './App.css'
import { nanoid } from "nanoid";
import Card from './Card'
import pregs from './info'

export default function App() {
  const [questions, setQuestions] = React.useState(pregs)
 

  function handleOption(id, option) {
    setQuestions(prevState => prevState.map(question => {
      return ( question.id === id ?
      {...question,
      answer: option}
      : question
    )}))
    console.log(id)
    console.log(option)
    console.log(questions[0].answer)

  }

  
  const questionElements = questions.map(q => {
    return (<Card 
            question={q.question}
            key={q.id}
            options={q.options}
            correctAnswer={q.correctAnswer}
            id={questions.id}
            handleOption={() => handleOption(questions.id)}
            />)
  })

  return(
    <div className="app--container">
      <form action="">
        {questionElements}
        <div className="div--check">
        <button className="check--answers">Check Answers</button>
        </div>  
      </form>
    </div>
  )
}







