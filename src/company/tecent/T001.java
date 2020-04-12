package company.tecent;

import java.util.Scanner;

/***
 *@ClassName T001
 *@Description
 * @author sukbear
 * @create 2019-09-10 9:55
 */
public class T001 {
/**
    给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
    输出需要删除的字符个数。
*/

    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            System.out.println(f(s));
        }
    }
    static int f(String str){
        StringBuilder sb1 = new StringBuilder(str);
        StringBuilder sb2 = new StringBuilder(str).reverse();
        int len = str.length();
        int[][] maxLen = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (sb1.charAt(i - 1) == sb2.charAt(j - 1))
                    maxLen[i][j] = maxLen[i - 1][j - 1] + 1;
                else
                    maxLen[i][j] = Math.max(maxLen[i - 1][j], maxLen[i][j - 1]);

            }
        }
        return len - maxLen[len][len];
    }
}
