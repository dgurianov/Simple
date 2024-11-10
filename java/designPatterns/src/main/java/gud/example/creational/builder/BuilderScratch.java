package gud.example.creational.builder;

/*
    Class to implement pattern
 */
public class BuilderScratch {
    public static void main(String[] args) {
        Salad carotSalad = new Salad.Builder("carrot").build();
        Salad tomatoPotato = new Salad.Builder("tomato").withIngridientTwo("potato").build();

    }
}


class Salad{
    private final String ingridientOneMandatory;
    private final String ingridientTwo;

    public static class Builder{
        private final String ingridientOneMandatory;
        private String ingridientTwo = "green leaves";


        public Builder(String ingridientOneMandatory) {
            this.ingridientOneMandatory = ingridientOneMandatory;
        }

        public Builder withIngridientTwo(String newIngridient){
            this.ingridientTwo = newIngridient;
            return this;
        }

        public Salad build(){
            return new Salad(this);
        }


    }


    private Salad(Builder b) {
        this.ingridientOneMandatory = b.ingridientOneMandatory;
        this.ingridientTwo = b.ingridientTwo;
    }
}
