package leetcode;

/***
 *@ClassName TicketsFee
 *@Description
 * @author sukbear
 * @create 2019-04-20 17:59
 */
public class TicketsFee {
/**    输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
    输出: 8
    解释: 能够达到的最大利润:
    在此处买入 prices[0] = 1
    在此处卖出 prices[3] = 8
    在此处买入 prices[4] = 4
    在此处卖出 prices[5] = 9
    总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
    public int maxProfit(int[] prices, int fee){
        int[][] dp = new int[prices.length][2];
        //第0天之后不持有股票，没花钱收益为0
        dp[0][0] = 0;
        //第0天之后持有股票，用了股票的价格的钱收益为-prices[0]
        dp[0][1] = -prices[0];
        for(int i = 1;i<prices.length;i++){
            //若前一天之后持有，卖出之后收益为:prices[i],付手续费：fee：prices[i]-fee
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][0]+prices[i]-fee);
            //若前一天不持有，买入付费为:prices[i]
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][0];
    }
}
