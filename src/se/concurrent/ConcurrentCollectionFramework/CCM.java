package se.concurrent.ConcurrentCollectionFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author sukbear
 * @create 2018-12-15 11:39
 */
public class CCM {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>(16);
        map.put("fuck","de");
        map.put("fck","de");
        map.put("fuk","de");
        List<String> list = new ArrayList<>();
        list = map.entrySet().stream().map(e->e.getKey()).filter((m)->"fuck".equals(m)).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
