package company.wangyi;

import java.util.Scanner;

/***
 *@ClassName wangyi003
 *@Description
 * @author sukbear
 * @create 2019-09-10 20:25
 */
public class wangyi003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(f(s));
    }
    static String f(String s){
        char[] chs = s.toCharArray();
        int count=1;
        char pre = chs[0];
        for(int i = 1;i<chs.length;i++){
            if(chs[i]!=pre){
                count++;
                pre = chs[i];
            }
        }
        //保留2位小数
        String result = String.format("%.2f", (double)s.length()/count);
        return result;
    }
}
