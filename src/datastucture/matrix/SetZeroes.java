package datastucture.matrix;

import java.util.ArrayList;
import java.util.List;

/***
 *@ClassName SetZeroes
 *@Description
 * @author sukbear
 * @create 2019-04-23 11:19
 */
public class SetZeroes {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
     * 输入:
     * [
     * [1,1,1],
     * [1,0,1],
     * [1,1,1]
     * ]
     * 输出:
     * [
     * [1,0,1],
     * [0,0,0],
     * [1,0,1]
     * ]
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (!row.contains(i)) {
                        row.add(i);
                    }
                    if (!col.contains(j)) {
                        col.add(j);
                    }
                }
            }
        }

        for (Integer e : row) {
            for (int j = 0; j < n; j++) {
                matrix[e][j] = 0;
            }
        }
        for (Integer e : col) {
            for (int j = 0; j < n; j++) {
                matrix[e][j] = 0;
            }
        }
    }
}
