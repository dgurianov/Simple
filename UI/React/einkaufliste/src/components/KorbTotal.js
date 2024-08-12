import { useRecoilValue } from "recoil";
import { korbState } from "../states/AppStates";



const KorbTotal = () => {
    const korb = useRecoilValue(korbState);
    const total = korb.reduce((total,currentV) => total = total+(currentV.quantity * currentV.price),0);
    return (
        <div> Total:
            {total<1 ? total.toFixed(2) : total.toPrecision(4)}
        </div>
    );
}

export default KorbTotal;