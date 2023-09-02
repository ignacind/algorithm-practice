


const Card = (props) => {
    let status;
    if (props.openSpots === 0) {
        status = "SOLD OUT"
    } else if (props.location === "Online") { status = "ONLINE" };
    
    return (
        <div className="card--container">
            
            <div className="card--image">
                {status && <div className="card--product--status">{status}</div>}
                <img src={"src/" + props.img} alt="" className="card--product--image" />
            </div>
            <div className="card--product-review">
                <span><i class="fa-solid fa-star"></i>{props.stats.rating}</span>
                <span className="gray">({props.stats.reviewCount}) • </span>
                <span className="gray">{props.location}</span>
            </div>

            <p className="card--product--info--title">{props.title}</p>
            <p className="card--product--info--price" s><span className="bold">From ${props.price}</span> / person</p>

        </div>

    );
}

export default Card;