package algorithm.unionfindset;

import java.util.Arrays;

/***
 *@ClassName FindCircleNumFindUnion
 *@Description
 * @author sukbear
 * @create 2019-09-07 15:51
 */
public class FindCircleNumFindUnion {
    private int[] parent;

    public int findCircleNum(int[][] M) {
        int N = M.length;
        parent = new int[N];
        // 默认初始化-1自己为根
        Arrays.fill(parent, -1);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        // 查找所有的根(值为-1)的个数即为集合的个数
        int cnt = 0;
        for (int id : parent) {
            if (id == -1) {
                cnt++;
            }
        }
        return cnt;
    }
    private void union(int x, int y){
        int xf = findRoot(x);
        int yf = findRoot(y);
        // 如果不在同一个集合中，合并
        if(xf!=yf){
            parent[yf]=xf;
        }
    }

    private int findRoot(int id){
        if(parent[id]==-1){
            return id;
        }
        //路径压缩，递归
        parent[id]=findRoot(parent[id]);
        return parent[id];
    }
}
