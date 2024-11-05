package gud.example.creational.abstractfactory;

public class GuitarFactorySample {
    public static void main(String[] args) {
        Guitar myFancyStrat = AbstractGuitarFactory.getFactoryByIdWithDefaultGibson(GuitarTypeId.STRAT).createGuitar();
        System.out.println(myFancyStrat instanceof Stratocaster);
    }
}

//Products
abstract class Guitar{
    private String mensur;
}


class Stratocaster extends Guitar{}
class Gibson extends Guitar{}


enum GuitarTypeId {STRAT, GIBSON}

abstract class AbstractGuitarFactory{
    private static final GibsonFatory G_FACTORY = new GibsonFatory();
    private static final StratFactory S_FACTORY = new StratFactory();

    static AbstractGuitarFactory getFactoryByIdWithDefaultGibson(GuitarTypeId id){
        switch (id){
            case STRAT: return S_FACTORY;
            default:return G_FACTORY;
        }
    }
    public abstract Guitar createGuitar();
}

// Concrete factories
class StratFactory extends AbstractGuitarFactory{

    @Override
    public Guitar createGuitar() {
        return new Stratocaster();
    }
}

class GibsonFatory extends AbstractGuitarFactory{

    @Override
    public Guitar createGuitar() {
        return new Gibson();
    }
}

