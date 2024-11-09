package gud.example.creational.builder;

/*
    Class to implement pattern
 */
public class BuilderDemoScratch {
    public static void main(String[] args) {
        Salad carotSalad = new Salad.Builder("carrot").build();
        Salad tomatoPotato = new Salad.Builder("tomato").withIngredient2("potato").build();

    }
}


class Salad{
    private final String ingredient1;
    private final String ingredient2;


    public static class Builder{
        private final String ingredient1;
        private String ingredient2 = "green iceberg";

        public Builder(String ingredient1) {
            this.ingredient1 = ingredient1;
        }

        public Builder withIngredient2(String newIngredient){
            this.ingredient2 = newIngredient;
            return this;
        }

        public Salad build(){
            return new Salad(this);
        }


    }


    private Salad(Builder b) {
        this.ingredient1 = b.ingredient1;
        this.ingredient2 = b.ingredient2;
    }
}
