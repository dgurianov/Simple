package gud.example.creational.factorymethod;

public class FactoryMethod1 {
}

interface Fish{
    void swim();
}

class HorseFish implements Fish{

    @Override
    public void swim() {
        System.out.println("I swim ");
    }
}

class DogFish implements Fish{

    @Override
    public void swim() {
        System.out.println("I barkswim");
    }
}

class FishFactory{
    public Fish getFish(String type){
        switch (type) {
            case "dog":
                return new DogFish();
            case "horse":
                return new HorseFish();
            default :
                throw new RuntimeException("Unknown fish");
        }

    }
}

