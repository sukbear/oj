package common.LRU;

/**
 * @author sukbear
 * @create 2018-12-16 21:02
 */
public class Main {
    public static void main(String[] args) {
        LRUCache<String,String> lruCache = new LRUCache<>(4);
        lruCache.put("one","1");
        lruCache.put("two","2");
        lruCache.put("three","3");
        lruCache.put("four","4");
        lruCache.put("five","5");
        System.out.println(lruCache.size());
        System.out.println(lruCache);
        lruCache.keySet().forEach(System.out::println);
        System.out.println(lruCache.get("two"));
        lruCache.keySet().forEach(System.out::println);
    }
}
