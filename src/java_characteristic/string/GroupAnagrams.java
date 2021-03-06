package java_characteristic.string;

import java.util.*;

/***
 *@ClassName GroupAnagrams
 *@Description
 * @author sukbear
 * @create 2019-04-22 10:28
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs.length==0){return new ArrayList();}
        Map<String,List> map = new HashMap<>();
        for(String s:strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
