package se.common.LRU;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sukbear
 * @create 2018-12-16 14:22
 */
public class LinkedLRU<K,V> extends LinkedHashMap<K,V>{
    private int cacheSize;
    private HashMap<K,Long> map = new HashMap<>();
    public LinkedLRU(int cacheSize) {
        super(16,0.75F, true);
        this.cacheSize = cacheSize;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>this.cacheSize;
    }


    public static void main(String[] args) {
        LinkedLRU<String,String> lruCache = new LinkedLRU<>(4);
        lruCache.put("k1","v1");
        lruCache.put("k2","v2");
        lruCache.put("k3","v3");
        lruCache.put("k4","v4");
        System.out.println(lruCache.get("k1"));
        lruCache.put("k5","v5");
        System.out.println(lruCache.get("k2"));
    }
}
