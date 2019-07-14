package niuke.KMP;

/***
 *@ClassName Kmp
 *@Description
 * @author sukbear
 * @create 2019-05-08 13:50
 */
public class Kmp {
    public static int kmp(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() == 0 || s1.length() < s2.length()) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNextArray(str2);
        while (i < s1.length() && j < s2.length()) {
            if (str1[i] == str2[j]) {
                i++;
                j++;
            }
            // j第一个位置
            else if (next[j] == -1) {
                i++;
            }
            // j 跳到next位置
            else {
                j = next[j];
            }
        }
        return j == s2.length() ? i - j : -1;
    }

    public static int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        //约定0位置为-1，（最长前缀）前缀不包含最后一个，后缀不包含最前一个。
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        //跳的位置
        int cn = 0;
        while (i < next.length) {
            //前一个字符和cn相等
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            }
            //cn往前跳
            else if (cn > 0) {
                cn = next[cn];
            }
            //不能在跳的时候
            else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(kmp("dest", "st"));
    }
}
