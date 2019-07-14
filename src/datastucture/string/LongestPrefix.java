package datastucture.string;

/***
 *@ClassName LongestPrefix
 *@Description
 * @author sukbear
 * @create 2019-04-20 17:37
 */
public class LongestPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     */
    static String helper(String s1, String s2) {
        if (s1 == null || s1 == null) {
            return "";
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int len = len1 < len2 ? len1 : len2;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                j++;
            } else {
                break;
            }
        }
        if (j == 0) {
            return "";
        }
        return s1.substring(0, j);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //利用String.indexOf()函数 返回匹配的索引位置，如果不匹配返回-1，匹配为0和其他
            while (strs[i].indexOf(prefix) != 0) {
                //不匹配或不完全匹配;
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
