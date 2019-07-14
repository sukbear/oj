package java_characteristic.pattern_matcher;

/***
 *@ClassName Pattern_Matcher
 *@Description
 * @author sukbear
 * @create 2019-04-05 11:12
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**注：\n 回车(\u000a)
        \t 水平制表符(\u0009)
        \s 空格(\u0008)
        \r 换行(\u000d)
 */
public class Pattern_Matcher {
    static public String replace(String s){
        String res ="";
        if(s!=null){
            Pattern p = Pattern.compile("\\s*|\n|\t|\r");
            Matcher m = p.matcher(s);
            res = m.replaceAll("");
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "dssd sds    dfd wedw we sdc" +
                " ";
        System.out.println(replace(s));
    }
}
