package datastucture.matrix;

/***
 *@ClassName matrix
 *@Description
 * @author sukbear
 * @create 2019-04-22 10:02
 */
public class matrix {
    /**
     * 顺时针旋转90度
     * 先交换行 （i行与n-i-1行）
     * 再交换dui角线两侧
     */
    /**
     * 逆时针旋转90度
     * 先交换dui角线两侧
     * 再交换行 （i行与n-i-1行）
     *
     */
    public void rotate(int[][] matrix) {
        //下交换行
        int n = matrix.length;
        for (int i = 0; i <= n / 2 - 1; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        //再交换对角线元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    continue;
                } else {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
