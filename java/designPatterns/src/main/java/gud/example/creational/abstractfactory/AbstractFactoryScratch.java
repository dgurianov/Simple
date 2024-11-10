package gud.example.creational.abstractfactory;

import gud.example.datastructures.core.stack.ArrayStack;

public class AbstractFactoryScratch {
    public static void main(String[] args) {
        AbstractSynthFactory sf = AbstractSynthFactory.getFactoryBySynthTypeWithDefaultRoland(SynthType.YAMAHA);
        sf.createSynth();


    }
}

interface Synth{};

class Yamaha implements Synth{};
class Roland implements Synth{};

enum SynthType{ROLAND,YAMAHA}


abstract class AbstractSynthFactory{
    private static final AbstractSynthFactory YAMAHA_FACTORY = new YamahaSynthFactory();
    private static final AbstractSynthFactory ROLAND_FACTORY = new RolandSynthFactory();


    public static AbstractSynthFactory getFactoryBySynthTypeWithDefaultRoland(SynthType type){
        switch (type){
            case YAMAHA : return YAMAHA_FACTORY;
            default: return ROLAND_FACTORY;
        }
    }


    public abstract Synth createSynth();
}


class RolandSynthFactory extends AbstractSynthFactory{

    @Override
    public Synth createSynth() {
        return new Roland();
    }
}


class YamahaSynthFactory extends AbstractSynthFactory{

    @Override
    public Synth createSynth() {
        return new Yamaha();
    }
}


