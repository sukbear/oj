package algorithm.dp;

/***
 *@ClassName algorithm.dp.Gift
 *@Description
 * @author sukbear
 * @create 2019-05-21 15:06
 */
public class Gift {
/**
 *
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
 *
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，
 *
 * 求拿到礼物的最大价值。例如，对于如下棋盘
 *
 * 1    10   3    8
 12   2    9    6
 5    7    4    11
 3    7    16   5
 礼物的最大价值为 1+12+5+7+7+16+5=53。
 */
    public int getMost(int[][] board) {
        if(board==null||board.length==0){
            return 0;
        }
        int m = board.length;
        int n = board[0].length;

        int max = 0;
        int[][] table = new int[m][n];
        for(int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                int left=0;
                int up=0;
              if(i>0){
                  left = table[i-1][j];
              }
              if(j>0){
                  up = table[i][j-1];
              }
              table[i][j]=board[i][j]+Math.max(left,up);
              max=Math.max(max,table[i][j]);
            }
        }
        return table[m-1][n-1];
    }
    public int getMost2(int[][] board) {
        if(board==null||board.length==0){
            return 0;
        }
        int n = board[0].length;
        int[] dp = new int[n];
        for(int[] row :board){
            dp[0]+=row[0];
            for(int i=1;i<n;i++){
                dp[i]=Math.max(dp[i],dp[i-1])+row[i];
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {

    }
}
