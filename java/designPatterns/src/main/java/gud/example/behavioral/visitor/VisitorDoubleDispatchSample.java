package gud.example.behavioral.visitor;

public class VisitorDoubleDispatchSample {

    public static void main(String[] args) {
        // given
        DiscountPolicy flatPolicy = new FlatDiscountPolicy();
        DiscountPolicy amountPolicy = new AmountBasedDiscountPolicy();
        Order orderWorth501Dollars = new Order();

        // when
        double flatDiscount = flatPolicy.discount(orderWorth501Dollars);
        double amountDiscount = amountPolicy.discount(orderWorth501Dollars);


        Order specialOrder = new SpecialOrder();
        SpecialDiscountPolicy specialPolicy = new SpecialDiscountPolicy1();
        specialPolicy.discount(specialOrder);
    }
}


class Order{
    public int totalCost(){
        return 501;
    }

}

class SpecialOrder extends Order{

}

interface DiscountPolicy {
    double discount(Order order);
}

class FlatDiscountPolicy implements DiscountPolicy {
    @Override
    public double discount(Order order) {
        return 0.01;
    }
}


interface SpecialDiscountPolicy extends DiscountPolicy {
    double discount(SpecialOrder order);
}


class    SpecialDiscountPolicy1 implements SpecialDiscountPolicy {
    @Override
    public double discount(Order order) {
        return 0.01;
    }

    @Override
    public double discount(SpecialOrder order) {
        return 0.10;
    }
};





class AmountBasedDiscountPolicy implements DiscountPolicy {
    @Override
    public double discount(Order order) {
        if (order.totalCost() > 500 ) {
            return 0.10;
        } else {
            return 0;
        }
    }
}

