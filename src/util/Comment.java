package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 *@ClassName Comment
 *@Description
 * @author sukbear
 * @create 2019-05-27 17:12
 */
public class Comment {
    static public String replace(String s){
        String res ="";
      Pattern p1 = Pattern.compile("\\*|\r|<[ ]>|{[ ]}");
        if(s!=null){
            Matcher m = p1.matcher(s);
            res = m.replaceAll("");
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "    /**\n" +
                "     * Wakes up a single thread that is waiting on this object's\n" +
                "     * monitor. If any threads are waiting on this object, one of them\n" +
                "     * is chosen to be awakened. The choice is arbitrary and occurs at\n" +
                "     * the discretion of the implementation. A thread waits on an object's\n" +
                "     * monitor by calling one of the ";
        System.out.println(replace(s));
    }
}
