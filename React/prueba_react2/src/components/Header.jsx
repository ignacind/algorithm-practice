import './Header.css'

const Header = () => {
    return (
    <header>
        <nav>
            <img src="src/imgs/images.png" alt="Logo" className='logo'/>
            <ul className="menu_items">
                <li><a href="#">Pricing</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </header>
    )
}

export default Header;