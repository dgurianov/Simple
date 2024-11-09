package gud.example.creational.singleton;

public class SingletonScratch {
    public static void main(String[] args) {

        MoneyConverter m  = MoneyConverter.getInstance();
    }
}



class MoneyConverter{
    private MoneyConverter() {
    }

    private static class Holder{
        private static final MoneyConverter INSTANCE = new MoneyConverter();
    }


    public static MoneyConverter getInstance(){
        return Holder.INSTANCE;
    };
}