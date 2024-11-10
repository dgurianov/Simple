package gud.example.behavioral.sendersreceivers.command;

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


public class KidsCommandSample {
}


class Kid{
    void cleanup(){        System.out.println("Cleaning up...");    }
    void eat(){        System.out.println("Eating cereal...");    }
    void sleep(){        System.out.println("Going to sleep...");    }
}

interface ParentsCommand{
    void execute();
}

class EatAndSleep implements ParentsCommand{
    private Kid kid ;

    @Override
    public void execute() {
        kid.eat();
        kid.sleep();
    }
}


class Cleanup implements ParentsCommand{
    private Kid kid;

    @Override
    public void execute() {
        kid.cleanup();
    }
}


//Command invoker
class Mama {
    List<ParentsCommand> parentsCommands = new ArrayList<>();

    public void planCommand(ParentsCommand comm){
        this.parentsCommands.add(comm);
    }

    public void executePlannedCommands(){
        //Mama does not know which command is being executed at each moment. She treats each command as a black box.
        for(ParentsCommand command : parentsCommands){
            command.execute();
        }
        parentsCommands.clear();
    }
}
