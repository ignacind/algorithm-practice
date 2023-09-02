

const MainContent = () => {
    return (
        <div className="main--container">
            <h3 className="main--h3 main--name">Laura Smith</h3>
            <h4 className="main--h4 main--title">Frontend Developer</h4>
            <h5 className="main--h5 main--website">laurasmith.website</h5>

            <ul className="main--ul--btn">
                <button className="main--btn btn--email">
                    <i class="fa-solid fa-envelope"></i> Email
                </button>
                <button className="main--btn btn--linkedin">
                    <i class="fa-brands fa-linkedin-in"></i> Linkedin
                </button>
            </ul>

            <div className="main--info">
                <h2>About</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel egestas dolor, nec dignissim metus. Donec augue elit, rhoncus ac sodales id, porttitor vitae est. Donec laoreet rutrum libero sed pharetra.</p>

                <h2>Interests</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laborum delectus voluptate excepturi iste omnis, explicabo velit rerum, autem cumque expedita hic aliquam adipisci atque. Ipsam necessitatibus repellendus facere distinctio. Culpa ab porro vel voluptatibus in similique repudiandae molestias?</p>
            </div>
        </div>
    )
};

export default MainContent;