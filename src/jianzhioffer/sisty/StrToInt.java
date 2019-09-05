package jianzhioffer.sisty;

/***
 *@ClassName StrToInt
 *@Description
 * @author sukbear
 * @create 2019-09-05 14:31
 */
public class StrToInt {
    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean negative = str.charAt(0)=='-';
        long ret = 0;
        for(int i = 0;i<str.length();i++){
           char c = str.charAt(i);
           if(i==0&&(c=='+'||c=='-')){
               continue;
           }
           if(c<'0'||c>'9'){
               return 0;
           }
           ret = ret *10+c-'0';
        }
        ret =  negative?-ret:ret;
        if(ret >Integer.MAX_VALUE||ret<Integer.MIN_VALUE){
            return 0;
        }
        return (int)(ret);
    }

    public static void main(String[] args) {
        System.out.println(strToInt("9223372036854775808"));
        System.out.println(Long.MAX_VALUE);
    }
}
