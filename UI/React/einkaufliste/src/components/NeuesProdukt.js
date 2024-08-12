import { useRecoilState } from "recoil";
import { korbState } from "../states/AppStates";
import {v4 as uuid} from 'uuid';
import { useState } from "react";

const NeuesProdukt = () => {
    const [korb , setKorb] = useRecoilState(korbState);
    const uuidFromUuidV4 = () => {return uuid()};
    const [neuesProdukt, setNeuesProdukt] = useState(
        {
            id: uuidFromUuidV4(),
            name: "Add Produkt",
            quantity: 1,
            price: 0.01
        }
    );


    const onChangeAny = (event) => {
        switch (event.target.name){
            case "changeName":
                setNeuesProdukt({
                    id: neuesProdukt.id,
                    name: event.target.value,
                    quantity: neuesProdukt.quantity,
                    price: neuesProdukt.price
                });
                break;
            case "changeQ":
                setNeuesProdukt({
                    id: neuesProdukt.id,
                    name: neuesProdukt.name,
                    quantity: event.target.value,
                    price: neuesProdukt.price
                });
                break;
            case "changePrice":
                setNeuesProdukt({
                    id: neuesProdukt.id,
                    name: neuesProdukt.name,
                    quantity: neuesProdukt.quantity,
                    price: event.target.value
                });
                break;
            default:
                break;

        };
    }

    const onClick = (event) => {
        if(neuesProdukt.name !== "Add Produkt"){
            setNeuesProdukt({
                id: uuidFromUuidV4(),
                name: neuesProdukt.name,
                quantity: neuesProdukt.quantity,
                price: neuesProdukt.price
            });
            setKorb([...korb,neuesProdukt]);
        }
    }

    return(
        <div className="container-np">
            <label>Name:</label>
            <input value={neuesProdukt.name} type="text" name="changeName" onChange={onChangeAny}/>
            <label>Quantity:</label>
            <input value={neuesProdukt.quantity} type="number" min="1" max="99" name="changeQ" onChange={onChangeAny}/>
            <label>Price x1</label>
            <input value={neuesProdukt.price} type="number" name="changePrice" min="0.00" max="999999.99" step="0.01" onChange={onChangeAny}/>
            <button onClick={onClick}> Add</button>
        </div>
    )



}

export default NeuesProdukt;