package algorithm.unionfindset;

/***
 *@ClassName Solution
 *@Description
 * @author sukbear
 * @create 2019-05-07 13:23
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int N = grid.length;
        int M = grid[0].length;
        int res = 0;
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(grid[i][j]=='1'){
                    res++;
                    infect(grid,i,j,N,M);
                }
            }
        }
        return res;
    }
    private void infect(char[][] grid,int i, int j, int N, int M){
        //非法值直接返回
        if(i<0||i>=N||j<0||j>=M||grid[i][j]!='1'){
            return;
        }
        //感染
        grid[i][j] = 2;
        //上下左右递归感染
        infect(grid,i+1,j,N,M);
        infect(grid,i-1,j,N,M);
        infect(grid,i,j+1,N,M);
        infect(grid,i,j-1,N,M);
    }

    public static void main(String[] args) {
        int[] a = {};
        System.out.println(a.length);
    }
}
