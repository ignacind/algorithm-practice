
// Create a new component called Footer that renders a <footer> element with the following content: social media buttons (Twitter, Facebook, Instagram, GitHub). This component must be exported as default.

const Footer = () => {
    return (
        <footer className="footer--container">
            <ul className="footer--ul--btn">
                <li><button className="footer--btn"><i class="fa-brands fa-twitter"></i></button></li>
                <li><button className="footer--btn"><i class="fa-brands fa-facebook-f"></i></button></li>
                <li><button className="footer--btn"><i class="fa-brands fa-instagram"></i></button></li>
                <li><button className="footer--btn"><i class="fa-brands fa-github"></i></button></li>
            </ul>
        </footer>
    )
}

export default Footer;



