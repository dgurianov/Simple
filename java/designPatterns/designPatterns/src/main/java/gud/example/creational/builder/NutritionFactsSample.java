package gud.example.creational.builder;

// Builder Pattern
public class NutritionFactsSample {
    private final int servings;
    private final int calories;

    //builder class should be static. Otherwise, we need to create an instance of the NutritionFacts class to access this Builder class.
    public static class Builder {
        // Required parameters
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories      = 0;

        public Builder( int servings) {
            this.servings    = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

        public NutritionFactsSample build() {
            return new NutritionFactsSample(this);
        }
    }

    private NutritionFactsSample(Builder builder) {
        servings     = builder.servings;
        calories     = builder.calories;
    }
}