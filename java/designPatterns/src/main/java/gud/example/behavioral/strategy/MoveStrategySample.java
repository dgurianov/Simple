package gud.example.behavioral.strategy;

public class MoveStrategySample {

    public static void main(String[] args) {
        MoveCompetitionContext competition = new MoveCompetitionContext(100);
        CannonShot cs = new CannonShot();
        TakeACab tc = new TakeACab();

        //The same context works with any strategy cause it does not care of implementation but only on declaration of interface
        //Strategies can be altered or added without changin the context
        competition.performMove(cs);
        competition.performMove(tc);

    }

}

interface MoveToDistanceStrategy{
    void execute(int kilometers);
}

class CannonShot implements MoveToDistanceStrategy{
    @Override
    public void execute(int kilometers) {
        System.out.println(String.format("Ive been shot  out of cannot for %d kilometers", kilometers));
    }
}

class TakeACab implements MoveToDistanceStrategy{
    @Override
    public void execute(int kilometers) {
        System.out.println(String.format("Took a cab for %d km", kilometers));
    }
}


class MoveCompetitionContext{
    private int distanceKm;

    public MoveCompetitionContext(int distanceKm) {
        this.distanceKm = distanceKm;
    }

    public void performMove(MoveToDistanceStrategy strategy){
        strategy.execute(this.distanceKm);
    }
}