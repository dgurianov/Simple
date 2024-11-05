package gud.example.behavioral.chainofresponsibility;

public class CookChainOfResponsibilitySample {
}

abstract class CookStep{
    private CookStep nextStep;

    public CookStep getNextStep() {
        return nextStep;
    }

    public void setNextStep(CookStep nextStep) {
        this.nextStep = nextStep;
    }

    public abstract void doStepAndNext(String incomingData);

    protected void doNextOrStop(String incomingData){
        if(this.nextStep != null){
            this.nextStep.doStepAndNext(incomingData);
        }else{
            System.out.println("End of chain");
        }
    }
}



class Wash extends CookStep{

    @Override
    public void doStepAndNext(String incomingData) {
        System.out.println("Washing");
        doNextOrStop(incomingData);
    }
}

class Cook extends CookStep{

    @Override
    public void doStepAndNext(String incomingData) {
        System.out.println("Cooking");
        doNextOrStop(incomingData);
    }
}
