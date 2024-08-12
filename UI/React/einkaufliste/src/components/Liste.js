import { useState } from "react";
import NeuesProdukt from "./NeuesProdukt";
import Com from "./Com";



const EinkaufListe = () => {
    const [listOfProducts,setListOfProducts] = useState([]);
    // console.log("EK"+{listOfProducts});
    // const listItems = ;
    return(
        <div className="container">
            <div className="header">HEADER</div>
            <div className="body">BODY </div>
                <div className="menu"> 
                    <NeuesProdukt listOfProducts={listOfProducts} setLp={ setListOfProducts}/>
                </div>
            <div className="footer">{listOfProducts.map((element)=>{return <Com props={element}/>})}</div>
        </div>
    );
};

export default EinkaufListe;