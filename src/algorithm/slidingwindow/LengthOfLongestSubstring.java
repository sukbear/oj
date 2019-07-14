package algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/***
 *@ClassName LengthOfLongestSubstring
 *@Description
 * @author sukbear
 * @create 2019-04-26 15:47
 */
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>

     */
    public int lengthOfLongestSubstring_1(String s) {
/*        使用 HashSet 将字符存储在当前窗口 [i, j)[i,j)（最初 j = ij=i）中。
        然后我们向右侧滑动索引 jj，如果它不在 HashSet 中，
        我们会继续滑动 jj。直到 s[j] 已经存在于 HashSet 中。
        此时，我们找到的没有重复字符的最长子字符串将会以索引 ii 开头。
        如果我们对所有的 ii 这样做，就可以得到答案。*/
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0,i=0,j=0;
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
   /** 以前的我们都没有对字符串 s 所使用的字符集进行假设。

    当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。*/
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        int[] index = new int[128];
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
