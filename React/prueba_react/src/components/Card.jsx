import vehicles from '../data/vehicles';
import './Card.css'
import { Link } from 'react-router-dom';
function Card({title='DefaulTitle', description='DefaultDesc'}) {
    return (<div className="Tarjeta">
        <Link to={title}><h2>{title}</h2></Link>
        <p>{description}</p>
    </div>);
}

export default Card;