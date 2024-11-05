package gud.example.behavioral.observer;

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
