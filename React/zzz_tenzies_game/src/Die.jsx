import react from 'react'


export default function Die(props) {
    const styles = {
        backgroundColor: props.isHeld ? '#59E391' : 'white'
    }
    return(
        <div 
            className='box' 
            style={styles} 
            onClick={() => props.beenPressed()}
        >
            <h2>{props.value}</h2>
        </div>
    )
}