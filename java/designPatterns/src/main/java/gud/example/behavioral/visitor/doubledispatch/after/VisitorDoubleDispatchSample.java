package gud.example.behavioral.visitor.doubledispatch.after;


/*
Visitor that SIMULATES double dispatch at

 d.accept(order);

  Java is a Single Dispatch polymorphism language. It selects a  method to call , looking on a single type provided(now it is Discount) per one method call.
  It does not descend into type sub-hierarchy to find exact type of the object (ChristmastDiscount or TenPercentDiscount) provided in runtime.

To simulate double dispatch , Discount objects  , should be proactive  and have their own methods

 */

import java.util.ArrayList;
import java.util.List;

public class VisitorDoubleDispatchSample {

    public static void main(String[] args) {

        List<Discount> discounts = new ArrayList<>();
        discounts.add(new ChristmasDiscount());
        discounts.add(new TenPercentDiscount());

        Order order = new Order1();

        for (Discount d : discounts){
            d.accept(order);
            /*
            First dispatch - dispatch Order to exact type Order1

            Second dispatch - dispatch interface type Discount to exact class type and choose the proper method of Order1 type.
            Second dispatch is not happening in this case , and code falls back to general applyDiscount(Discount discount)
             */
        }
    }
}

interface Discount {
    void accept(Order order);
}

class ChristmasDiscount implements Discount {
    @Override
    public void accept(Order order) {
        order.applyDiscount(this);

    }
}
class TenPercentDiscount implements Discount {
    @Override
    public void accept(Order order) {
        order.applyDiscount(this);
    }
}

interface Order {
    //Visitor method
    void applyDiscount(ChristmasDiscount discount);
    //Visitor method
    void applyDiscount(TenPercentDiscount discount);

    default void applyDiscount(Discount discount){
        System.out.println("No discount applied.");
    }
}

class Order1 implements Order {

    @Override
    public void applyDiscount(ChristmasDiscount discount) {
        System.out.println("Christmas discount applied.");
    }

    @Override
    public void applyDiscount(TenPercentDiscount discount) {
        System.out.println("Applied 10 percent discount");
    }

}
