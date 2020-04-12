package se.common.LRU;

import java.time.LocalDateTime;

/***
 *@ClassName TimeLocalChche
 *@Description
 * @author sukbear
 * @create 2019-08-06 17:06
 */
public class TimeLocalChche<V> {
    private  LocalDateTime time;
    private V data;
    public TimeLocalChche(V data){
        this.time = LocalDateTime.now();
        this.data = data;
    }
}
