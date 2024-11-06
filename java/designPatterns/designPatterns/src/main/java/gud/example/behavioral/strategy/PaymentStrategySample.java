package gud.example.behavioral.strategy;

public class PaymentStrategySample {

    //Common interface with common logic
    interface PaymentStrategy {
        void pay(int amount);

        //Common logic goes to interface
        boolean validatePaymentDetails();
    }

    class PaymentByCreditCard implements PaymentStrategy {

        @Override
        public void pay(int amount) {
            System.out.println("Paying by cc");
        }

        @Override
        public boolean validatePaymentDetails() {
            System.out.println("Validating");
            return true;
        }
    }

    class PayByPayPal implements PaymentStrategy {

        @Override
        public void pay(int amount) {
            System.out.println("Paying by paypal");
        }

        @Override
        public boolean validatePaymentDetails() {
            System.out.println("Validating");
            return true;
        }
    }

    class PaymentService {
        private int cost;
        //Service has no visibility of strategies , cause common interface hides them
        //Strategies might be changed or added without changing the service
        private PaymentStrategy strategy;

        public void processOrder() {
            if (strategy.validatePaymentDetails()) {
                strategy.pay(cost);
            }
        }
    }

}


