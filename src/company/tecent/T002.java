package company.tecent;

import java.util.Scanner;

/***
 *@ClassName T002
 *@Description
 * @author sukbear
 * @create 2019-09-10 10:09
 */
public class T002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            System.out.println(f(s));
        }
    }
   static String f(String s){
        char[] chs = s.toCharArray();
        for(int i = 0;i<chs.length;i++){
            for(int j = chs.length-1;j>i;j--){
                if(chs[j]>=97&&chs[j-1]<=90){
                    char c = chs[j];
                    chs[j] =chs[j-1];
                    chs[j-1] = c;
                }
            }
        }
        return new String(chs);
   }
}
