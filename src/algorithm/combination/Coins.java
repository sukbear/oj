package algorithm.combination;

import java.util.Scanner;

/***
 *@ClassName Coins
 *@Description
 * @author sukbear
 * @create 2019-09-09 22:05
 */
public class Coins {
//    有1分，2分，5分，10分四种硬币，每种硬币数量无限，给定n分钱(n <= 100000)，
// 有多少中组合可以组成n分钱？输出组合数，答案对1e9+7取模。

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int res = 0;
            int n = sc.nextInt();
            System.out.println(count(n));
        }
    }

    static int count(int n) {
        int[] coins = {1, 4, 5};
        int[] dp = new int[10000];
        dp[0]=1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }
}
