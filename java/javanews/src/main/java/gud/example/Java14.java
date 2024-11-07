package gud.example;

public class Java14 {
    enum Day {MON,TUE,WED}
    public static void main(String[] args) {
        //Switch
        //Before
        Day day = Day.MON;
        switch (day){
            case MON :
            case TUE:
                System.out.println("Workday!");
                break;
            case WED:
                System.out.println("Halfday");
                break;
            default:
                throw new IllegalArgumentException("Not a day!");
        }

        //After

        //(Optional)return
        switch (day){
            case WED ,TUE-> System.out.println("Great day!");
            case MON -> System.out.println("Not so great");
        };
    }
}

//Helpfull NullPointerException - more explanation in exception.
//Exception in thread "main" java.lang.NullPointerException:
//Cannot read field "J" because "b" is null
//at Prog.main(Prog.java:5)