package gud.example.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/*
Chain of Responsibility, Command, Mediator, and Observer, address how you can decouple senders and receivers, but with different trade-offs.
- Chain of Responsibility passes a sender request along a chain of potential receivers.
- Command normally specifies a sender-receiver connection with a subclass.
- Mediator has senders and receivers reference each other indirectly.
- Observer defines a very decoupled interface that allows for multiple receivers to be configured at run-time.

A command object is used to encapsulate a call to a method at runtime.
Effective when used in event routing.


 */

public class BrokerCommandSample {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        //Use Broker to execute commands
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);

        broker.executeOrders();
    }


}
//Command interface
interface Order {
    void execute();
}

//request class
class Stock {

    private String name = "ABC";

    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
//Implement Order interface - this is the command
class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}

//Create command invoker class
class Broker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void executeOrders(){

        //Decoupling call form implementation : Broker treats each Order as blackbox , without knowing what execute will actually do.
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
