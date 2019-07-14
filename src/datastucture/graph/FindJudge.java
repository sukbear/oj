package datastucture.graph;

/***
 *@ClassName FindJudge
 *@Description
 * @author sukbear
 * @create 2019-05-21 15:07
 */
public class FindJudge {
    /***
     *
     * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。

     如果小镇的法官真的存在，那么：

     小镇的法官不相信任何人。
     每个人（除了小镇法官外）都信任小镇的法官。
     只有一个人同时满足属性 1 和属性 2 。
     给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。

     如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。

     输入：N = 3, trust = [[1,3],[2,3],[3,1]]
     输出：-1

     输入：N = 3, trust = [[1,2],[2,3]]
     输出：-1

     输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
     输出：3
     题解：找到那个入度为N-1,出度为0的点。
     限制：
     1 <= N <= 1000
     trust.length <= 10000
     trust[i] 是完全不同的
     * trust[i][0] != trust[i][1]
     1 <= trust[i][0], trust[i][1] <= N
     */
    public int findJudge(int N, int[][] trust) {
        int[][] people = new int[N][2];
        for(int[] arg: trust){
            people[arg[0]-1][0]++;
            people[arg[1]-1][1]++;
        }
        for(int i = 0;i<people.length;i++){
            if(people[i][0]==0&&people[i][1]==N-1){
                return i+1;
            }
        }
        return -1;
    }
}
