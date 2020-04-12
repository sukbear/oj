package company.wangyi;

import java.util.Scanner;

/***
 *@ClassName wangyi001
 *@Description
 * @author sukbear
 * @create 2019-09-10 11:10
 */
public class wangyi001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(f(n));
        }
    }

    static String f(int n) {
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            if (n % 2 == 0) {
                n = (n - 2) / 2;
                s.append(2);
            } else {
                n = (n - 1) / 2;
                s.append(1);
            }
        }
        return s.reverse().toString();
    }

}
