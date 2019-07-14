package niuke.KMP;

/***
 *@ClassName Ex
 *@Description
 * @author sukbear
 * @create 2019-05-08 15:29
 */
public class Ex {
    public static void main(String[] args) {
        System.out.println(res("abcabc"));
    }
    public static String res(String s1) {
        String s = s1+"1";
        String temp = "";
        int[] next = Kmp.getNextArray(s.toCharArray());
        int index = next[s1.length()];
        for(int i = index;i<s1.length();i++){
            temp+=s1.charAt(i);
        }
        return s1+temp;
    }
    /**
     * 给定一个字符串s,请计算输出含有连续两个s作为子串的最短字符串。注意两个s可能有重叠部分。
     * 例如，"ababa"含有两个“aba".
     输入描述：
      输入包括一个字符串s,字符串长度length(1<=length<=50),s中每个字符都是小写字符。
     输出描述：
      输出一个字符串，即含有连续两个s作为子串的最短字符串。
     示例1
      输入：abracadabra
      输出：abracadabracadabra

      思路：求出原字符串的next数组，假设原字符串长度为n，再求next[n]位置的值，表示后面需要补下标为next[n]开始到结尾的字符，举个例子：str=abracadabra，next值分别是-1,0,0,0,1,0,1,0,1,2,2，然后再求next[n]的值为4，所以从下标为4开始一直往后的字符全部添加到结尾就变成了abracadabracadabra*/
    //有两个字符串构成的最短字符串“abcabc"->"abcabcabc"
    //原字符串+一个字符。求出next数组，源字符串+len-最后一个字符的next值的长度
}
