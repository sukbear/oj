package common.LRU;

import java.util.HashMap;

/***
 *@ClassName LRUCache
 *@Description
 * @author sukbear
 * @create 2019-08-06 15:55g
 */
public class LRUCache<K, V> {
    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(2);
        lruCache.put("df", "df");
        lruCache.put("dfdd", "fdd");
        lruCache.put("dffd", "ef");
        System.out.println(lruCache.get("df"));
    }

    private int MAX_CACHE_SIZE;
    private Entry first;
    private Entry last;
    private HashMap<K, Entry<K, V>> map = new HashMap<>();

    public LRUCache(int cacheSize) {
        this.MAX_CACHE_SIZE = cacheSize;
        map = new HashMap<>(cacheSize);
    }

    public void put(K key, V value) {
        Entry entry = getEntry(key);
        if (entry == null) {

            if (map.size() >= MAX_CACHE_SIZE) {
                map.remove(last.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.vlaue = value;
        moveToFirst(entry);
        map.put(key, entry);
    }

    public V get(K key) {
        Entry<K, V> entry = map.get(key);
        if (entry == null) {
            return null;
        }
        moveToFirst(entry);
        return entry.vlaue;
    }

    public void remove(K key) {
        Entry entry = map.get(key);
        // 在链表中删除
        if (entry != null) {
            if (entry.pre != null) {
                entry.pre.next = entry.next;
            }
            if (entry.next != null) {
                entry.next.pre = entry.pre;
            }
            if (entry == first) {
                first = entry.next;
            }
            if (entry == last) {
                last = entry.pre;
            }
        }
        //map中删除
        map.remove(key);

    }

    private void moveToFirst(Entry entry) {
        //第一个直接返回
        if (entry == first) {
            return;
        }
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }
        if (entry == last) {
            last = entry.pre;
        }
        //只有一个元素
        if (first == null || last == null) {
            first = last = entry;
            return;
        }
        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            //元素个数超过1个时
            if (last.pre != null) {
                last.pre.next = null;
            } else {
                // 删完不存在结点时
                first = null;
            }
            last = last.pre;
        }

    }

    private Entry<K, V> getEntry(K key) {
        return map.get(key);
    }

    class Entry<K, V> {
        Entry pre;
        Entry next;
        K key;
        V vlaue;
    }
}
