package gud.example.others.resourcepool;


import java.util.HashMap;
import java.util.Map;

public class ResourcePoolSample {
}

class CachedObject {
    public String temp1;

    public String getTemp1() {
        return temp1;
    }
    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }
}

class ObjectPool {
    private static long expTime = 6000;//6 seconds
    public static HashMap<CachedObject, Long> available = new HashMap<>();
    public static HashMap<CachedObject, Long> inUse = new HashMap<CachedObject, Long>();

    public synchronized static CachedObject getObject() {
        long now = System.currentTimeMillis();
        if (!available.isEmpty()) {
            for (Map.Entry<CachedObject, Long> entry : available.entrySet()) {
                if (now - entry.getValue() > expTime) { //object has expired
                    popElement(available);
                } else {
                    CachedObject po = popElement(available, entry.getKey());
                    push(inUse, po, now);
                    return po;
                }
            }
        }

        // either no CachedObject is available or each has expired, so return a new one
        return createCachedObject(now);
    }

    private synchronized static CachedObject createCachedObject(long now) {
        CachedObject po = new CachedObject();
        push(inUse, po, now);
        return po;
    }

    private synchronized static void push(HashMap<CachedObject, Long> map,
                                          CachedObject po, long now) {
        map.put(po, now);
    }

    public static void releaseObject(CachedObject po) {
        cleanUp(po);
        available.put(po, System.currentTimeMillis());
        inUse.remove(po);
    }

    private static CachedObject popElement(HashMap<CachedObject, Long> map) {
        Map.Entry<CachedObject, Long> entry = map.entrySet().iterator().next();
        CachedObject key= entry.getKey();
        //Long value=entry.getValue();
        map.remove(entry.getKey());
        return key;
    }

    private static CachedObject popElement(HashMap<CachedObject, Long> map, CachedObject key) {
        map.remove(key);
        return key;
    }

    public static void cleanUp(CachedObject po) {
        po.setTemp1(null);
    }
}
