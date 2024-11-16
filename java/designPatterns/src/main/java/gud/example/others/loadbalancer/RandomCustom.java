package gud.example.others.loadbalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCustom implements LoadBalanceCustom{
    List<String> servers = new ArrayList<>(ServersPool.servers.keySet());

    @Override
    public String getServer() {
        return servers.get(new Random().nextInt(servers.size()));
    }
}
