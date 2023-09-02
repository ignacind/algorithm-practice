

const Card = (props) => {

    return (
        <div className="card--container">
            <img src={props.imageUrl} alt="" />
            <div className="card--info">

                <span><i class="fa-solid fa-location-dot"></i>{props.location}<a href={props.googleMapsUrl} className="google--maps">View on Google Maps</a></span>

                <h1 className="card--title">{props.title}</h1>

                <p className="card--date">{props.startDate} - {props.endDate}</p>
                <p className="card--description">
                    {props.description}
                </p>

            </div>
        </div>
    );
}

export default Card;