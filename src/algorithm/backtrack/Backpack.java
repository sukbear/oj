package algorithm.backtrack;

/***
 *@ClassName Backpack
 *@Description
 * @author sukbear
 * @create 2019-05-08 21:19
 */
public class Backpack {
    public static int maxValue(int[] weights, int[] values, int bag) {
        return process(weights, values, 0, 0, bag);
    }

    public static int process(int[] weights, int[] values, int i, int haveweight, int bag) {
        if (haveweight > bag) {
            return Integer.MIN_VALUE;
        }
        //到达最后返回
        if (i == weights.length) {
            return 0;
        }
        //要不要第i号货物
        return Math.max(process(weights, values, i + 1, haveweight, bag),
                values[i] + process(weights, values, i + 1, weights[i] + haveweight, bag));
    }

    public static int maxValue2(int[] c, int[] p, int bag) {
        //从0到n的填充，从0到bag的填充
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int[] c = {3, 2, 4, 7};
        int[] p = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(maxValue2(c, p, bag));
    }
}
