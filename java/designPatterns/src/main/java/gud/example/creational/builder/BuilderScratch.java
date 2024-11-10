package gud.example.creational.builder;

/*
    Class to implement pattern
 */
public class BuilderScratch {
    public static void main(String[] args) {
        Salad carotSalad = new Salad.Builder("carrot").build();
        Salad tomatoPotato = new Salad.Builder("tomato").withNewOptionalIngridient("potato").build();

    }
}


class Salad{

    private final String ingridientMandatory;
    private final String ingridientOPtionalWithDefault;

    public static class Builder {
        private final String ingridientMandatory;
        private String ingridientOPtionalWithDefault = "greenLeaves";

        public Builder(String ingridientMandatory) {
            this.ingridientMandatory = ingridientMandatory;
        }

        public Builder withNewOptionalIngridient(String newOptionalIngridient){
            this.ingridientOPtionalWithDefault = newOptionalIngridient;
            return this;
        }


        public Salad build(){
            return new Salad(this);
        }

    }


    private Salad(Builder b) {
        this.ingridientMandatory = b.ingridientMandatory;
        this.ingridientOPtionalWithDefault = b.ingridientOPtionalWithDefault;
    }
}
