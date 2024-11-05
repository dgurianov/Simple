package gud.example.creational.prototype;
import java.util.HashMap;


public class MusicProtoSample {
    public static void main(String[] args) {
        InstrumentsCache cache = new InstrumentsCache();
        MusicInstrument instrument = cache.getInstrumentById("39KeysPiano");
        instrument.doSound();
    }
}





interface MusicInstrument{
    public void  doSound();
    public MusicInstrument copy();
}

class Guitar implements MusicInstrument{
    private int numberOfStrings;

    public Guitar(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void doSound() {
        System.out.printf("Guitar plays  sound with %d of strings", this.numberOfStrings);
    }

    @Override
    public MusicInstrument copy() {
        return new Guitar(this.numberOfStrings);
    }
}

class Piano implements MusicInstrument{
    private int numberOfKeys;

    public Piano(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    @Override
    public void doSound() {
        System.out.printf("Piano plays a sound using %d keys",this.numberOfKeys);
    }

    @Override
    public MusicInstrument copy() {
        return new Piano(this.numberOfKeys);
    }
}


class InstrumentsCache{
    private HashMap<String, MusicInstrument> cache = new HashMap<>();

    private void warmup(){
        this.cache.put("7StringGuitar", new Guitar(7));
        this.cache.put("39KeysPiano", new Piano(39));
    }

    public MusicInstrument getInstrumentById(String id ){
        if (cache.isEmpty()) warmup();
        return this.cache.get(id).copy();
    }

}


