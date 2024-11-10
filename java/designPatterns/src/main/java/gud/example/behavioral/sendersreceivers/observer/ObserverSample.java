package gud.example.behavioral.sendersreceivers.observer;

/*
Chain of Responsibility, Command, Mediator, and Observer, address how you can decouple senders and receivers, but with different trade-offs.
- Chain of Responsibility passes a sender request along a chain of potential receivers.
- Command normally specifies a sender-receiver connection with a subclass.
- Mediator has senders and receivers reference each other indirectly.
- Observer defines a very decoupled interface that allows for multiple receivers to be configured at run-time.

 */


/*
Observer design pattern

    Model the "independent" functionality with a "subject" abstraction
    Model the "dependent" functionality with "dp.behavioral.observer" hierarchy
    The Subject is coupled only to the Observer base class
    Observers register themselves with the Subject
    The Subject broadcasts events to all registered Observers
    Observers "pull" the information they need from the Subject
    Client configures the number and type of Observers

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void add(Observer o) {
        observers.add(o);
    }

    public int getState() {
        return state;
    }

    public void setState(int value) {
        this.state = value;
        execute();
    }

    private void execute() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    public void update() {
        System.out.print(" " + Integer.toHexString(subject.getState()));
    }
}


public class ObserverSample {
    public static void main( String[] args ) {
        Subject sub = new Subject();
        // Client configures the number and type of Observers
        new HexObserver(sub);
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("\nEnter a number: ");
            sub.setState(scan.nextInt());
        }
    }
}
