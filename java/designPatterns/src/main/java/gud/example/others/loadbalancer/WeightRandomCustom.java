package gud.example.others.loadbalancer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class WeightRandomCustom implements LoadBalanceCustom{

    public static void main(String[] args) {
        int numberOfRuns = 100;
        HashMap<String,Integer> results = new HashMap<>();
        WeightRandomCustom w = new WeightRandomCustom();
        String s = "";

        System.out.println("Weights : ");
        w.printCurrentWeights();

        while(numberOfRuns >= 0) {
            s = w.getServer();
            results.put(s,results.getOrDefault(s,1)+1);
            numberOfRuns--;
        }

        System.out.println("--------------------");
        System.out.println("Results : ");
        results.keySet().stream().forEach(e->{
            System.out.println("%s : %d".formatted(e,results.get(e)));
        });

    }


    @Override
    public String getServer() {
        //The more weight - the more chances to get server
        HashMap<Integer,String> weightToServerMap = new HashMap<>();
        int totalWeight = 0;
        for(String ip :new ArrayList<>(ServersPool.servers.keySet())){
            totalWeight = totalWeight +ServersPool.servers.get(ip);
            weightToServerMap.put(totalWeight,ip);
        }
        int randomWeight = new Random().nextInt(totalWeight);
        String chosenServer = null;
        while(chosenServer == null){
           chosenServer = weightToServerMap.get(randomWeight);
           if(chosenServer != null) return chosenServer;
           randomWeight++;
        }
        return null;
    }



    private void printCurrentWeights(){
        for(String server : ServersPool.servers.keySet()){
            System.out.println(" %s : %d".formatted(server, ServersPool.servers.get(server)));
        }
    }
}

