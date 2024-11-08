package gud.example.structural.AdapterDecoratorFacadeDelegation;


class DecoratorExoticDrinksMachine{
    private DrinksMachineAllSamples drinksMachine;
    //More responsibility than in original more exotic combinations than in original functionality.

    public DecoratorExoticDrinksMachine(DrinksMachineAllSamples drinksMachine) {
        this.drinksMachine = drinksMachine;
    }

    public void noSleep24hoursEnergyAwakeaccinoInGlass(){
        this.drinksMachine.plusD(100);
        this.drinksMachine.plusD(100);
        this.drinksMachine.plusD(100);
        this.drinksMachine.plusC(10);
        this.drinksMachine.plusA(1000);
        this.drinksMachine.deliverProduct(DrinkType.COFFEE,GlassType.GLASS);

    }

    public void relaxMintTeaWithLemonInCup(){
        this.drinksMachine.plusE(50);
        this.drinksMachine.isL(true);
        this.drinksMachine.plusC(100);
        this.drinksMachine.deliverProduct(DrinkType.TEA,GlassType.TEA_CUP);
    }
    //...etc.. more methods than original drinks machine
}

class FacadeCoffeeMachine{
    private DrinksMachineAllSamples drinksMachine;
    //Simplified wrapper to deliver only two coffee drinks to the client

    public FacadeCoffeeMachine(DrinksMachineAllSamples drinksMachine) {
        this.drinksMachine = drinksMachine;
    }

    public void getGlassOfEspresso(){
        this.drinksMachine.plusD(100);
        this.drinksMachine.plusC(100);
        this.drinksMachine.deliverProduct(DrinkType.COFFEE,GlassType.GLASS);
    }

    public void getCupOfCapuccino(){
        this.drinksMachine.plusD(100);
        this.drinksMachine.plusC(100);
        this.drinksMachine.plusB(50);
        this.drinksMachine.deliverProduct(DrinkType.COFFEE,GlassType.COFFEE_CUP);
    }
}



class AdapterToDrinkMachine{
    private DrinksMachineAllSamples originalDrinkMachine;
    //All other methods form Drink machine but with different names , so customer can figure out what is going on with the drink

    public AdapterToDrinkMachine(DrinksMachineAllSamples originalDrinkMachine) {
        this.originalDrinkMachine = originalDrinkMachine;
    }

    public void getDesiredDrink(DrinkType type,GlassType glass){
        originalDrinkMachine.deliverProduct(type,glass);
    }
    public void addMoreSugar(int sugar){
        originalDrinkMachine.plusA(sugar);
    }
    //...etc...
}

enum GlassType{GLASS,COFFEE_CUP, TEA_CUP}
enum DrinkType{TEA,COFFEE,WATER}
public class DrinksMachineAllSamples {
    private DrinkType type;
    private int sugarAmount = 0;
    private int milkAmount = 0;
    private int waterAmount = 100;
    private boolean lemon = false;
    private int coffeeAmount = 0;
    private int teaAmount = 0;


    public void deliverProduct(DrinkType dType, GlassType gType){
        System.out.printf("Prepare drink %s in glass %s with:\n" +
                "Sugar: %d\n" +
                "Milk: %d\n" +
                "Water: %d\n" +
                "Lemon: %s\n" +
                "Coffee: %d\n" +
                "Tea: %d\n",dType,gType,this.sugarAmount,this.milkAmount,this.waterAmount,this.lemon,this.coffeeAmount,this.teaAmount);
    }

    public void plusA(int sugar){
        this.sugarAmount = sugar;
    }

    public void plusB(int milkAmount) {
        this.milkAmount = milkAmount;
    }

    public void plusC(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void isL(boolean lemon) {
        this.lemon = lemon;
    }

    public void plusD(int coffeeAmount) {
        this.coffeeAmount = coffeeAmount;
    }

    public void plusE(int teaAmount) {
        this.teaAmount = teaAmount;
    }
}
