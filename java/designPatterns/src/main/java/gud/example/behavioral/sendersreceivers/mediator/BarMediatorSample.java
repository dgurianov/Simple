package gud.example.behavioral.sendersreceivers.mediator;

import java.util.HashMap;
import java.util.Map;

public class BarMediatorSample {
    public static void main(String[] args) {
        RichGuy richDirk = new RichGuy("richDirk");
        PoorGuy poorJohn = new PoorGuy("poorJohn");
        Bartender bt = new Bartender();
        bt.registerClient(richDirk);
        bt.registerClient(poorJohn);

        //Mediator initiates poorJohn to send drink to reachDirk
        bt.facilitateDrink(poorJohn.getName(),richDirk.getName());

        //Mediator initiates reachDirk to send drink to  poorJohn
        bt.facilitateDrink(richDirk.getName(),poorJohn.getName());
    }
}

//Components - bar members
interface BarClient{
    void setBarMediator(BarMediator mediator);
    void acceptDrink(String drink);
    String buyDrink();
    String getName();

}

class RichGuy implements BarClient{
    //Link to bartender for each client
    private BarMediator bartender;
    private String name;

    public RichGuy(String name) {
        this.name = name;
    }

    @Override
    public void setBarMediator(BarMediator mediator) {
        this.bartender = mediator;
    }

    @Override
    public void acceptDrink(String drink) {
        System.out.printf("%s : got a drink ! It is %s! Thank you! %n \n", name,drink );
    }

    @Override
    public String buyDrink() {
        System.out.printf("%s: buys a drink for someone\n",name);
        return "Bourbon";
    }

    @Override
    public String getName() {
        return this.name;
    }
}

class PoorGuy implements BarClient{
    //Link to bartender for each client
    private BarMediator bartender;
    private String name;

    public PoorGuy(String name) {
        this.name = name;
    }

    @Override
    public void setBarMediator(BarMediator mediator) {
        this.bartender = mediator;
    }

    @Override
    public void acceptDrink(String drink) {
        System.out.printf("%s : got a drink ! It is  %s! Thank you! %n\n", name,drink );
    }

    @Override
    public String buyDrink() {
        System.out.printf("%s: buys a drink for someone\n", name);
        return "Water";
    }

    @Override
    public String getName() {
        return this.name;
    }
}



//Mediator contract
interface BarMediator{
    //Perform action on behalf of the components
    void facilitateDrink(String fromClient , String toClient);
    void registerClient(BarClient client);


}

class Bartender implements BarMediator{
    Map<String,BarClient> clients = new HashMap<>();


    @Override
    public void facilitateDrink(String fromClient, String toClient) {
        System.out.printf("Bratender Mediator : New round! I mediate %s to buy a drink  to %s! \n",fromClient,toClient);
        clients.get(toClient)
                .acceptDrink(
                        clients.get(fromClient)
                                .buyDrink()
                );

    }

    @Override
    public void registerClient(BarClient client) {
        client.setBarMediator(this);
        System.out.printf("Bartender Mediator : New client at the table! It is %s ! \n",client.getName());
        clients.put(client.getName(),client);
    }
}