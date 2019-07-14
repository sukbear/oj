package common.LRU;

import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sukbear
 * @create 2018-12-16 14:22
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V>{
    private int cacheSize;
    private HashMap<K,Long> map = new HashMap<>();
    public LRUCache(int cacheSize) {
        super(16,0.75F, true);
        this.cacheSize = cacheSize;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>this.cacheSize;
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }


    private class ChcheData<T>{
        private T data;
        private long saveTime; // 存活时间
        private long expire;   // 过期时间 小于等于0标识永久存活

        public ChcheData(T data, long saveTime, long expire) {
            this.data = data;
            this.saveTime = Instant.now().toEpochMilli();
            this.expire = saveTime+expire;
        }
        T getData(){
            return data;
        }
        long getExpire(){
            return expire;
        }
        long getSaveTime(){
            return saveTime;
        }
    }
}
