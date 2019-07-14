package se.other.generic;

/**
 * @author sukbear
 * @create 2018-12-17 9:28
 */
public class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    public static <K, V> boolean compareKey(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey());
    }

    public static <K, V> boolean compareValue(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getValue().equals(p2.getValue());
    }

    public static <T> T print(A<T> a){
        return a.getT();
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    static class A<T> {
        private T t;



        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1, "Apple");
        Pair<Integer, String> p2 = new Pair<>(1, "Peer");
        A<String> a = new A<>();
        a.setT("test");
        System.out.println(Util.compare(p1, p2));
        System.out.println(Util.compareKey(p1, p2));
        System.out.println(Util.print(a));
    }
}
