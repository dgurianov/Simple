package gud.example.behavioral.templatemethod;

/*
The Template Method pattern is quite common in Java frameworks. Developers often use it to provide framework users with a
simple means of extending standard functionality using inheritance.
Template Method is a behavioral design pattern that allows you to defines a skeleton of an algorithm in a base class and
let subclasses override the steps without changing the overall algorithm’s structure.
 */
public class TemplateMethodSample {
    //Use the Game's template method play() to demonstrate a defined way of playing game.
    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}

//abstract class with a template method being final.
abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //template method
    public final void play(){

        //initialize the game
        initialize();

        //start game
        startPlay();

        //end game
        endPlay();
    }
}
//concrete classes extending the above class.
class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}

class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
