package datastucture.matrix;

/***
 *@ClassName LongestIncreasingPath
 *@Description
 * @author sukbear
 * @create 2019-05-28 19:51
 */

/**
 * 给出一个数字矩阵，寻找一条最长上升路径，每个位置只能向上下左右四个位置移动。nums = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Return 4  1->2-> 6-> 9
 */
public class LongestIncreasingPath {
    boolean[][] flag;
    int[][] dp;
    int n, m;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int getLongestLen(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        n = matrix.length;
        m = matrix[0].length;
        int ans = 0;
        dp = new int[n][m];
        flag = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = search(i, j, matrix);
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

    int search(int x, int y, int[][] matrix) {
        //访问过直接返回
        if (flag[x][y]) {
            return dp[x][y];
        }
        int ans = 1;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m&& matrix[nx][ny] < matrix[x][y]) {
                ans = Math.max(ans, search(nx, ny, matrix) + 1);
            }
        }
        flag[x][y] = true;
        dp[x][y] = ans;
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        LongestIncreasingPath obj = new LongestIncreasingPath();
        System.out.println(obj.getLongestLen(matrix));
    }
}
