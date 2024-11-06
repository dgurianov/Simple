package gud.example.behavioral.state;

public class FishStateSample {
    public static void main(String[] args) {
        FishContext fishContext = new FishContext();
        AliveFish aliveFish = new AliveFish();
        DeadFish deadFish = new DeadFish();
        aliveFish.doAction(fishContext);
        deadFish.doAction(fishContext);
    }
}
interface FishState{
    void doAction(FishContext context);
}

class DeadFish implements FishState{
    @Override
    public void doAction(FishContext context) {
        System.out.println("The fish died.");
        context.setState(this);
    }
}

class AliveFish implements FishState{

    @Override
    public void doAction(FishContext context) {
        System.out.println("The Fish is alive again!");
        context.setState(this);
    }
}

class FishContext{
    public FishState getState() {
        return state;
    }

    public void setState(FishState state) {
        this.state = state;
    }

    private FishState state;

}