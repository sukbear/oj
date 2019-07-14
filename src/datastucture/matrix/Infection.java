package datastucture.matrix;

/***
 *@ClassName datastucture.matrix.Infection
 *@Description
 * @author sukbear
 * @create 2019-05-21 12:51
 */
public class Infection {
    /**
     * 岛屿最大面积，有一个连通点面积加一，
     * 求相连的面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j, m, n));
            }
        }
        return maxArea;
    }


    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += dfs(grid, i + 1, j, m, n);
        area += dfs(grid, i - 1, j, m, n);
        area += dfs(grid, i, j + 1, m, n);
        area += dfs(grid, i, j - 1, m, n);
        return area;
    }

    /**
     * 从每个起始点开始，等于与他相连且值相等的把值换成新值
     * 1、建一个访问标记数组
     * 2、未访问的才访问。
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return image;
        }
        int origin = image[sr][sc];
        int[][] visited = new int[image.length][image[0].length];
        helper(image, sr, sc, origin, newColor, visited);
        return image;
    }

    private void helper(int[][] image, int i, int j, int origin, int newColor, int[][] visited) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != origin || visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;
        image[i][j] = newColor;
        helper(image, i + 1, j, origin, newColor, visited);
        helper(image, i - 1, j, origin, newColor, visited);
        helper(image, i, j + 1, origin, newColor, visited);
        helper(image, i, j - 1, origin, newColor, visited);
    }
}
