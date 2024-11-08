package gud.example.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class SpiesSample {
    public static void main(String[] args) {
        SpyOriginator spy = new SpyOriginator();
        MaskCarrierCareTaker maskCarrier = new MaskCarrierCareTaker();
        spy.setCurrentMask("BlackFace");
        spy.setCurrentMask("WhiteFace");
        maskCarrier.add(spy.saveMask());
        spy.setCurrentMask("Yellow");
        //Restore mask from from maskCarrier memento list
        spy.putOnMask(maskCarrier.get(0));
    }



}




class MementoMask{
    private String mask;

    public MementoMask(String mask) {
        this.mask = mask;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }
}


class SpyOriginator{
    private String currentMask;

    public String getCurrentMask() {
        return currentMask;
    }

    public void setCurrentMask(String currentMask) {
        this.currentMask = currentMask;
    }

    public MementoMask saveMask(){ return new MementoMask(this.currentMask);
    }

    public void putOnMask(MementoMask mementoMask){
        this.currentMask = mementoMask.getMask();
    }
}


class MaskCarrierCareTaker{
    private List<MementoMask> maskList = new ArrayList<>();
    public void add(MementoMask mask){maskList.add(mask);}
    public MementoMask get(int index){return maskList.get(index);}

}
