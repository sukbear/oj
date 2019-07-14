package algorithm.dp;

/***
 *@ClassName MessageEncode
 *@Description
 * @author sukbear
 * @create 2019-04-16 17:18
 */
public class MessageEncode {
/*    一条包含字母 A-Z 的消息通过以下方式进行了编码：

            'A' -> 1
            'B' -> 2
            ...
            'Z' -> 26
    给定一个只包含数字的非空字符串，请计算解码方法的总数。
    输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
    */


    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];
            if (i > 1 && (s.charAt(i - 1) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= 6))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

}
