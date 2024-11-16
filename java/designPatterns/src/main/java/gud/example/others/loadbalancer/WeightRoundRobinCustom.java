package gud.example.others.loadbalancer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/*
The more weight server has the earlier it will appear in round-robin
 */
public class WeightRoundRobinCustom implements  LoadBalanceCustom{
    public static Integer position = 0;


    public static void main(String[] args) {
        int numberOfRuns = 1000;
        HashMap<String,Integer> results = new HashMap<>();
        WeightRoundRobinCustom w = new WeightRoundRobinCustom();
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
        List<String> serverListWithWeight = new ArrayList<>();
        Iterator<String> iterator = ServersPool.servers.keySet().iterator();
        while(iterator.hasNext()){
            String serverItem = iterator.next();
            Integer weight = ServersPool.servers.get(serverItem);
            if(weight >0){
                for(int i=0 ; i < weight; i++ ){
                    serverListWithWeight.add(serverItem);
                }
            }
        }

        synchronized (position){
            if(position >= serverListWithWeight.size()) position = 0;
            String target = serverListWithWeight.get(position);
            position++;
            return target;
        }
    }


    private void printCurrentWeights(){
        for(String server : ServersPool.servers.keySet()){
            System.out.println(" %s : %d".formatted(server, ServersPool.servers.get(server)));
        }
    }
}
