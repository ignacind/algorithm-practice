import React from "react";
import { nanoid } from "nanoid";

export default function Card(props) {
    const [selected, setSelected] = React.useState("")
 
    
    function handleClick(option) {
        setSelected(option)
        
      
    }

    const options = props.options.map(op => {
        return (<div 
            key={nanoid()}
            className="op--btn" 
            onClick={() => {handleClick(op)
                props.handleOption(props.id, op)}}
            style={{backgroundColor: selected===op ? "#D6DBF5" : "White"}}
            >
                {op}
                </div>)
    })
    return(
        <div className="card--container">
            <h4>{props.question}</h4>
            <div className="options">
                {options}
            </div>
            <hr />
        </div>
    )
}