package gud.example.behavioral.state;

public class StateScratch {
    public static void main(String[] args) {

    }
}

interface PaymentState{
    public void proceed(PaymentContext ctx);
}

class  PaymentNewState implements PaymentState{

    @Override
    public void proceed(PaymentContext ctx) {
        System.out.println("Switched to NEW state.");
        ctx.setState(this);
    }
}


class PaymentUnProgressState implements PaymentState{

    @Override
    public void proceed(PaymentContext ctx) {
        System.out.println("Switched to In Progress.");
        ctx.setState(this);
    }
}



class PaymentContext{
    private PaymentState state;

    public PaymentState getState() {
        return state;
    }

    public void setState(PaymentState state) {
        this.state = state;
    }
}