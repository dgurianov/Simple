import { useRecoilState } from "recoil";
import { korbState } from "../states/AppStates";

const KorbListe = () => {

    const [korb, setKorb] = useRecoilState(korbState);

    const onClickDelete = (event) =>{
        const updatedKorb = korb.filter((item)=>{
            return item.id !== event.target.value;
        });
        setKorb(updatedKorb);
    }

    const renderedItems = korb.map((item,index)=>{
        return(<article key={item.id}>
            <header>{item.name}</header>
            Quantity:{item.quantity}
            Price:{item.price}
            <footer>Total:{item.price * item.quantity}
            <button value={item.id} onClick={onClickDelete}> Del</button>
            </footer>

        </article>)
    })
    return(<div>{renderedItems}</div>);
}


export default KorbListe;