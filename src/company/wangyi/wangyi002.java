package company.wangyi;

import java.util.Scanner;

/***
 *@ClassName wangyi002
 *@Description
 * @author sukbear
 * @create 2019-09-10 11:16
 */
public class wangyi002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        System.out.println(f(num));


    }

    static int f(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        String s = sb.reverse().toString();
        char[] chars = s.toCharArray();
        int i = 0;
        for (; i < chars.length; i++) {
            if (chars[i] != '0') {
                break;
            }
        }
        s = s.substring(i);
        int e = Integer.parseInt(s);
        return e + num;
    }
}
