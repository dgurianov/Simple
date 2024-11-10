package gud.example.creational.abstractfactory;

import gud.example.datastructures.core.stack.ArrayStack;

public class AbstractFactoryScratch {
    public static void main(String[] args) {
SynthAbstractFactory yf  = SynthAbstractFactory.getFactoryWithDefaultRoland(SynthTypes.YAMAHA);
    yf.createSynth();


    }
}


abstract class Synth{
   private int keys;
}

class Yamaha extends Synth{}
class Roland extends Synth{}

enum SynthTypes{ROLAND, YAMAHA}

abstract class SynthAbstractFactory{
    private static final SynthAbstractFactory YAMA_FACTORY = new YamaFactory();
    private static final SynthAbstractFactory ROLNAD_FACTORY = new RolandFactory();

    static SynthAbstractFactory getFactoryWithDefaultRoland(SynthTypes type){
        switch (type){
            case YAMAHA : return YAMA_FACTORY;
            default: return ROLNAD_FACTORY;

        }
    }

   public abstract Synth createSynth();

}





class YamaFactory extends SynthAbstractFactory{

    @Override
    public Synth createSynth() {
        System.out.println("Created Yama");
        return new Yamaha();
    }
}



class RolandFactory extends SynthAbstractFactory{

    @Override
    public Synth createSynth() {
        System.out.println("Created Roland");
        return new Roland();
    }
}