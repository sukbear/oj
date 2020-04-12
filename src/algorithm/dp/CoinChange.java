package algorithm.dp;

import java.util.Arrays;

/***
 *@ClassName CoinChange
 *@Description
 * @author sukbear
 * @create 2019-09-07 21:00
 */
public class CoinChange {
/**
    给定不同面额的硬币 coins 和一个总金额 amount。
 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 如果没有任何一种硬币组合能组成总金额，返回-1。
*/
/***
 * 不输出每种面值是多少
*/
    public  static int coinChange(int[] coins, int amount) {
        int max = amount;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i = 1;i<=amount;i++){
            for(int j = 0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
    /**带每种零钱个数限制*/
    public  static int coinChanges(int[] coins, int amount,int[] coinCount) {
        int max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        // 面值总数
        for(int i = 0;i<coins.length;i++){
            // 对应面值的个数
            for(int j=1;j<=coinCount[i];j++){
                for(int k=amount;k>=coins[i];k--){
                    dp[k] = Math.min(dp[k],dp[k-coins[i]]+1);
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {9,4};
        int[] coinCount={2,1};
        System.out.println(coinChanges(coins,22,coinCount));
    }
}
