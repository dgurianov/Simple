package gud.example.others.loadbalancer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoundRobinCustom implements LoadBalanceCustom{
    private static Integer position = 0;
    private String ip = null;


    public static void main(String[] args) {
        int numberOfRuns = 1000;
        HashMap<String,Integer> results = new HashMap<>();
        RoundRobinCustom w = new RoundRobinCustom();
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

    private void printCurrentWeights(){
        for(String server : ServersPool.servers.keySet()){
            System.out.println(" %s : %d".formatted(server, ServersPool.servers.get(server)));
        }
    }

    @Override
    public String getServer() {
        List<String> servers = new ArrayList<>(ServersPool.servers.keySet());
        synchronized (position){
            if(position > servers.size() -1) position = 0 ;
            ip = servers.get(position);
            position++;
        }
        return ip;
    }
}
