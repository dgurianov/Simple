package gud.example.others.loadbalancer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServersPool {
    public static Map<String,Integer> servers = new ConcurrentHashMap<>();
    static {
        servers.put("172.16.1.1",10);
        servers.put("172.16.1.2",40);
        servers.put("172.16.1.3",80);
    }
}
