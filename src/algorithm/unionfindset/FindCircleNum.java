package algorithm.unionfindset;

/***
 *@ClassName LongestConsecutive
 *@Description
 * @author sukbear
 * @create 2019-05-11 13:20
 */
public class FindCircleNum {
    /**
     使用一个visited数组, 依次判断每个节点, 如果其未访问,
     朋友圈数加1并对该节点进行dfs搜索标记所有访问到的节点
     **/
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for(int i = 0;i<M.length;i++){
            if(!visited[i]){
                res++;
                search(M,visited,i);
            }
        }
        return res;
    }
    private void search(int[][] M,boolean[] visited,int index){
        for(int j = 0;j<M.length;j++){
            if(M[index][j]==1&&!visited[j]){
                visited[j]=true;
                search(M,visited,j);
            }
        }
    }
}
