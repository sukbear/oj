package service;

import java.util.UUID;

/***
 *@ClassName Uuid
 *@Description
 * @author sukbear
 * @create 2019-05-21 19:46
 */
public class Uuid {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
