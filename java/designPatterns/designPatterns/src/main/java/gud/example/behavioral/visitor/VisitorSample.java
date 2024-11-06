package gud.example.behavioral.visitor;


public class VisitorSample {
    public static void main(String[] args) {
        GlobalOrder sp = new SpecialOrder3();
        DiscountVisitor dv = new Discount3Visitor();
        //First dispatch , method is selected at runtime while object  is casted to glob
        sp.accept(dv);


    }
}


interface GlobalOrder{
    void accept(DiscountVisitor dv);
}

class Order3 implements GlobalOrder{
    @Override
    public void accept(DiscountVisitor dv) {
        dv.discount(this);

    }
}

class SpecialOrder3 implements GlobalOrder {
    @Override
    public void accept(DiscountVisitor dv) {
        //Second dispatch happens , cause now we are running discount(SpecialOrder3 specialOrder3) despite SpecialOrder3 is child of Order3 and we  with @override we should be run discount(Order3 order)
        dv.discount(this);
    }
}


interface DiscountVisitor{
    void discount(Order3 order);
    void discount(SpecialOrder3 specialOrder3);

}

class Discount3Visitor implements DiscountVisitor{

    @Override
    public void discount(Order3 order) {
        System.out.println("Discounting order3");
    }

    @Override
    public void discount(SpecialOrder3 specialOrder3) {
        System.out.println("Discounting special order 3 ");
    }
}



