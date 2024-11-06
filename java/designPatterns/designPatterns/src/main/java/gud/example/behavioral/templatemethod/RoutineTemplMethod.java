package gud.example.behavioral.templatemethod;

public class RoutineTemplMethod {
}


abstract class MorningRoutine {
    abstract void  doFirstActivity();
    abstract void  doSecondActivity();
    abstract void  doThirdActivity();

    public final void startTheDay(){
        doFirstActivity();
        doSecondActivity();
        doThirdActivity();
    }

}

class StudentRoutine extends MorningRoutine{

    @Override
    void doFirstActivity() {
        System.out.println("Prepare to exam");
    }

    @Override
    void doSecondActivity() {
        System.out.println("Brush your teeth. ");

    }

    @Override
    void doThirdActivity() {
        System.out.println("Run to classed");

    }
}

class BankRobberRoutine extends MorningRoutine{

    @Override
    void doFirstActivity() {
        System.out.println("Rob the bank");
    }

    @Override
    void doSecondActivity() {
        System.out.println("Get into hideout");
    }

    @Override
    void doThirdActivity() {
        System.out.println("Brush your teeth");
    }
}

