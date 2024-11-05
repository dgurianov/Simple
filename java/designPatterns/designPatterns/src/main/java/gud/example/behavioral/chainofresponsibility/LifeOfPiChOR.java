package gud.example.behavioral.chainofresponsibility;

public class LifeOfPiChOR {
    public static void main(String[] args) {
        Birth b = new Birth();
        University u = new University();
        Death d = new Death();
        b.setNextStep(u);
        u.setNextStep(d);
        b.performStepAndStartNext("Pi");
    }
}

abstract class LifePeriod{
    private LifePeriod nextStep;

    public LifePeriod getNextStep() {
        return nextStep;
    }

    public void setNextStep(LifePeriod nextStep) {
        this.nextStep = nextStep;
    }

    public abstract void performStepAndStartNext(String name);

    protected void doNextOrStop(String name){
        if (getNextStep() != null) {
            getNextStep().performStepAndStartNext(name);
        }else {
            System.out.printf("%s life has ended\n",name);
        }

    }
}

class Birth extends LifePeriod{

    @Override
    public void performStepAndStartNext(String name) {
        System.out.printf("%s was born \n",name);
        doNextOrStop(name);
    }
}

class University extends LifePeriod{

    @Override
    public void performStepAndStartNext(String name) {
        System.out.printf("%s goes to Uni\n",name);
        doNextOrStop(name);
    }
}

class Death extends LifePeriod{

    @Override
    public void performStepAndStartNext(String name) {
        System.out.printf("%s died\n",name);
        doNextOrStop(name);
    }
}

