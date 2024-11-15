package gud.example.creational.prototype;

import java.util.Collections;
import java.util.HashMap;

public class PrototypeScratch {
}


interface Car {
    public void doDriveSound();
    public Car copy();
}

class RacingCar implements Car{
    private boolean withNitro;

    public RacingCar(boolean withNitro) {
        this.withNitro = withNitro;
    }

    @Override
    public void doDriveSound() { System.out.println("I`m racing car"); }

    @Override
    public Car copy() { return new RacingCar(this.withNitro); }

}


class PassangersCar implements Car{
    private int numberOfPassangers;

    public PassangersCar(int numberOfPassangers) {
        this.numberOfPassangers = numberOfPassangers;
    }

    @Override
    public void doDriveSound() { System.out.println("I`m passangers car with %s".formatted(this.numberOfPassangers)); }

    @Override
    public Car copy() { return new PassangersCar(this.numberOfPassangers); }

}

class CarsCache{
    private HashMap<String, Car> cache = new HashMap<>();

    private void warmUp(){
        this.cache.put("NitroRacing", new RacingCar(true));
        this.cache.put("4PassangersCar", new PassangersCar(4));
    }

    public Car getCarById(String id ){
        if(cache.isEmpty()) warmUp();
        return cache.get(id).copy();
    }
}