package gud.example.behavioral.sendersreceivers.observer;

import java.util.ArrayList;
import java.util.List;

public class OldGrannyObserver {
    public static void main(String[] args) {
        Grandma grandma = new Grandma();
        HappyRichDaughter hd = new HappyRichDaughter(grandma);
        PoorDrunkSon ps = new PoorDrunkSon(grandma);
        grandma.checkOnGrandma();

    }
}


abstract class GrandmaObserver{
    //Typical grandma observer knows that Grandma exist
    protected Grandma grandmaSubject;
    //Typical grandma observer wants only know whether she is alive
    public abstract void isSheDeadYetUpdate();
}

class Grandma{
    private boolean state;

    public boolean isAlive() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    //Grandma knows who might her visit
    private List<GrandmaObserver> observers = new ArrayList<>();

    public void add(GrandmaObserver observer) {observers.add(observer);}

    //Grandma can identify her state ang ping all observers  that she knows
    public void checkOnGrandma(){
        if (state){
            System.out.println("Granny : I`m still alive :b ! \n");
        }else{
            System.out.println("Granny :  X( ...\n");
        }
        for(GrandmaObserver observer : observers){
            observer.isSheDeadYetUpdate();
        }
    }
}


class HappyRichDaughter extends GrandmaObserver{

    public HappyRichDaughter(Grandma grandma) {
        this.grandmaSubject = grandma;
        //Register yourself as grandma observer, let grandma know that you`ll be checking on her
        this.grandmaSubject.add(this);
    }

    //React on the status change of grandma
    @Override
    public void isSheDeadYetUpdate() {
        System.out.println("Daughter : i hope  she is OK  and i`ll get cookies!");
        if (this.grandmaSubject.isAlive()){
            System.out.println("Daughter : Thanks God, she is fine! And cookies are yummy!\n");
        }else{
            System.out.println("Daughter : Oh no! She is Dead !  Now i need more storage for the money i`ll inherit!!!\n");
        }

    }
}


class PoorDrunkSon extends GrandmaObserver{
    public PoorDrunkSon(Grandma grandma) {
        this.grandmaSubject = grandma;
        //Register yourself as grandma observer, let grandma know that you`ll be checking on her
        this.grandmaSubject.add(this);
    }

    //React on the status change of grandma
    @Override
    public void isSheDeadYetUpdate() {
        System.out.println("Son : i hope she is dead and i`ll get her money!");
        if (this.grandmaSubject.isAlive()){
            System.out.println("Son : Well, she`s still alive...\n");
        }else{
            System.out.println("Son : Oh yeah! She is dead! And i`m getting richer and more drunk!\n");
        }
    }
}
