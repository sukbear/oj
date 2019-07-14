package datastucture.hash;

import java.util.HashMap;
import java.util.Map;

/***
 *@ClassName MaxSubString
 *@Description
 * @author sukbear
 * @create 2019-04-17 14:14
 */
public class MaxSubString {
    /*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。*/

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
