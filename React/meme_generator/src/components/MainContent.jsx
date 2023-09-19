
import React from "react";


const MainContent = (props) => {
    
    const [meme, setMeme] = React.useState({
            topText: "",    
        bottomText: "",
        memeImage: "https://i.imgflip.com/26jxvz.jpg"});
    
    const [allMemes, setAllMemes] = React.useState([]);

    React.useEffect(() => { 
        fetch("https://api.imgflip.com/get_memes")
            .then(res => res.json())
            .then(data => setAllMemes(data.data.memes))
    }, [])
    
    const getMemeImage = () => {
        const randomIndexMeme = Math.floor(Math.random() * allMemes.length);
        setMeme(prevMeme => ({...prevMeme, memeImage: allMemes[randomIndexMeme].url}));

    };

    const handleText = (event) => {
        const {name, value} = event.target;
        setMeme(prevMeme => ({...prevMeme, [name]: value}));
    }

    return (
        <main className="main--container">
            <div className="main--form">

                <input type="text" 
                placeholder="Top text" className="main--form--input input1"
                name="topText"
                onChange={handleText}
                value={meme.topText} />

                <input type="text" placeholder="Bottom text" className="main--form--input input2"
                name="bottomText"
                onChange={handleText}
                value={meme.bottomText} />
                <button className="main--form--button"
                onClick={getMemeImage} >Get a new meme image  🖼</button>
            </div>

            <div className="main--generate--meme">

                <img src={meme.memeImage} alt="Meme" className="main--meme"/>

                <h2 className="main--meme--text top-text">{meme.topText}</h2>
                <h2 className="main--meme--text bottom-text">{meme.bottomText}</h2>
            </div>
            
        </main>
    );
}


export default MainContent;