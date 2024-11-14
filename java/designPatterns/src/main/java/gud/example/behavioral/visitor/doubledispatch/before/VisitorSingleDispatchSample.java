package gud.example.behavioral.visitor.doubledispatch.before;


/*
Visitor with single dispatch.
Run the main to see that it prints wrong message because that type dispatch  happens only once.
 order1.applyDiscount(d)

  Java is a Single Dispatch polymorphism language. It selects a  method to call , looking on a single type provided(now it is Discount).
  It does not descend into type sub-hierarchy to find exact type of the object (ChristmastDiscount or TenPercentDiscount) provided in runtime.

 */

import java.util.ArrayList;
import java.util.List;

public class VisitorSingleDispatchSample {

    public static void main(String[] args) {

        List<Discount> discounts = new ArrayList<>();
        discounts.add(new ChristmasDiscount());
        discounts.add(new TenPercentDiscount());

        Order order = new BigOrder();

        for (Discount d : discounts){
            order.applyDiscount(d);
            /*
            First dispatch - dispatch Order to exact type Order1

            Second dispatch - dispatch interface type Discount to exact class type and choose the proper method of Order1 type.
            Second dispatch is not happenning in this case , and code falls back to general applyDiscount(Discount discount)
             */
        }
    }
}

interface Discount { }

class ChristmasDiscount implements Discount{}
class TenPercentDiscount implements Discount{}

interface Order {

    void applyDiscount(ChristmasDiscount discount);

    void applyDiscount(TenPercentDiscount discount);

    default void applyDiscount(Discount discount){
        System.out.println("Not clear which discount to apply....");
    }
}

class BigOrder implements Order{

    @Override
    public void applyDiscount(ChristmasDiscount discount) {
        System.out.println("Christmas discount applied.");
    }

    @Override
    public void applyDiscount(TenPercentDiscount discount) {
        System.out.println("Applied 10 percent discount");
    }

}
