package datastucture.array;

/***
 *@ClassName gameTheory
 *@Description
 * @author sukbear
 * @create 2019-05-06 15:24
 */
public class gameTheory {
    /**玩家一是否会赢 */
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dps = new int[n][n];
        //dps[i][i]为玩家一从i到i赢得，肯定只能是nums【i】
        for (int i = 0; i < n; i++) {
            dps[i][i] = nums[i];
        }
        //d=1,其实代表，先算两个数的时候
        for (int d = 1; d < n; d++) {
            //有多少组要比较
            for (int j = 0; j < n - d; j++) {
                //比较j到d+j
                //其实意思就是比较j到d+j时，玩家1，只能选择两端的，
                //玩家一选择了j时，那么玩家二就从j+1到d+j中选最大的。
                //玩家一选了d+j时，那么玩家二就从j到d+j-1中选最大的
                dps[j][d + j] = Math.max(nums[j] - dps[j + 1][d + j], nums[d + j] - dps[j][d + j - 1]);
            }
        }
        //两个玩家相等，玩家一仍然胜利。
        return dps[0][n - 1] >= 0;
    }

    /**
     * 递归，存在大量的重复计算
     */
    public static int fun(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int f = f(arr, 0, arr.length - 1);
        int sum = 0;
        for (int s : arr) {
            sum += s;
        }
        return Math.max(f, sum - f);
    }

    /**
     * 先拿的函数
     */
    public static int f(int[] arr, int i, int j) {
        //递归出口 先拿只剩一个元素
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    /**
     * 后拿的函数
     */
    public static int s(int[] arr, int i, int j) {
        //递归出口 后拿不剩元素
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    public static int dpfun(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[][] fdp = new int[n][n];
        int[][] sdp = new int[n][n];
        for (int i = 0; i < n; i++) {
            fdp[i][i] = arr[i];
            sdp[i][i] = 0;
        }
        int count = 1;
        while (count++ < n) {
            for (int i = 0; i < n - 1; i++) {
                int j = i + count;
                if (j < n) {
                    fdp[i][j] = Math.max(fdp[i][i] + sdp[i + 1][j], fdp[j][j] + sdp[i][j - 1]);
                    sdp[i][j] = Math.min(fdp[i + 1][j], fdp[i][j - 1]);
                } else {
                    break;
                }
            }
        }
        return fdp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 2, 4};
        System.out.println(fun(a));
    }

}
